using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using SQLite;
using TareaPDMfinal.ClasesporTablas;

namespace TareaPDMfinal.MetodosSQLite
{
    class MetodosSQLiteTipoProyecto
    {
        //Constructor 
        public MetodosSQLiteTipoProyecto() { }

        //Metodo Insertar
        public String Insert(string dbPath, string codigo, string nombre)
        {
            if (vacios(codigo, nombre) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<TipoProyecto>("select * from TipoProyecto").Where(c => c.codigotp == codigo).FirstOrDefault();
                    if (existing == null)
                    {
                     db.RunInTransaction(() =>{db.Insert(new TipoProyecto(){codigotp = codigo,nombretp = nombre,});});
                        return "Se Guardo con exito";
                    }
                    else
                    {
                        return "Ya hay un TIPO con ese codigo";
                    }
                }
            }
            else return "";
        }

        //***********METODO UPDATE**************//
        public string Update(string dbPath, string codigo, string nombre)
        {
            if (vacios(codigo, nombre) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    string auxCodigo = codigo;
                    var existing = db.Query<TipoProyecto>("select * from TipoProyecto").Where(c => c.codigotp == auxCodigo).FirstOrDefault();
                    if (existing != null)
                    {
                        existing.nombretp = nombre;
                        db.RunInTransaction(() =>
                        {
                            db.Update(existing);
                        });
                        return "El TipoProyecto con el codigo: " + existing.codigotp + " se cambio con exito";
                    }
                    else
                    {
                        return "El TipoProyecto con ese codigo no existe";
                    }
                }
            }
            else
                return "";
        }


        // ********** METODO DELETE *********************** //
        public string[] Delete(string dbPath, string codigo)
        {
            if (codigo != String.Empty)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<TipoProyecto>("select * from TipoProyecto").Where(c => c.codigotp == codigo).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codigotp, existing.nombretp, "El TipoProyecto anterior se borro correctamente" };
                        db.RunInTransaction(() =>
                        {
                            db.Delete(existing);
                        });
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { codigo, "", "El TipoProyecto con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("No a digitado el codigo del TipoProyecto a borrar");
                string[] vec = new string[] { "", "", "" };
                return vec;
            }
        }


        // ********** METODO CONSULTA *********************** //
        public string[] Consulta(string dbPath, string codigo)
        {
            if (codigo != String.Empty)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<TipoProyecto>("select * from TipoProyecto").Where(c => c.codigotp == codigo).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codigotp, existing.nombretp, "Encontrado" };
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { "", "", "El TipoProyecto con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("Error debe digitar el codigo del TipoProyecto");
                string[] vec = new string[] { "", "", "" };
                return vec;
            }
        }


        // Metodo Auxiliar
        public Boolean vacios(string codigo, string nombre)
        {
            if (codigo == String.Empty)
            {
                MessageBox.Show("ERROR falta que Digite el codigo del TipoProyecto");
                return true;
            }
            else
            {
                if (nombre == String.Empty)
                {
                    MessageBox.Show("ERROR falta que digite el nombre del TipoProyecto");
                    return true;
                }
                  else { return false; }
             }
       }

    }
}
