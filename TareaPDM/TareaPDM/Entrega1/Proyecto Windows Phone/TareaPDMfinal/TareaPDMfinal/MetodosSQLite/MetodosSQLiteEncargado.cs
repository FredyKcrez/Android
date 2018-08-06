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
    class MetodosSQLiteEncargado
    {
        //Constructor 
        public MetodosSQLiteEncargado() { }

        //Metodo Insertar
        public String Insert(string dbPath, string codigo, string nombree, string apell, string sexoe, string email)
        {
            if (vacios(codigo, nombree, apell, sexoe, email) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Encargado>("select * from Encargado").Where(c => c.codencarg == codigo).FirstOrDefault();
                    if (existing == null)
                    {
                        db.RunInTransaction(() =>
                        {
                            db.Insert(new Encargado()
                            {

                                codencarg = codigo,
                                nombre = nombree,
                                apellido = apell,
                                sexo = sexoe,
                                correo = email,
                            });
                        });
                        return "Se Guardo con exito";
                    }
                    else
                    {
                        return "Ya hay una Encargado con ese codigo";
                    }
                }
            }
            else return "";
        }


        //***********METODO UPDATE**************//
        public string Update(string dbPath, string codigo, string nombree, string apell, string sexoe, string email)
        {
            if (vacios(codigo, nombree, apell, sexoe, email) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    string auxCodigo = codigo;
                    var existing = db.Query<Encargado>("select * from Encargado").Where(c => c.codencarg == auxCodigo).FirstOrDefault();
                    if (existing != null)
                    {
                        existing.nombre = nombree;
                        existing.apellido = apell;
                        existing.sexo = sexoe;
                        existing.correo = email;

                        db.RunInTransaction(() =>
                            {
                                db.Update(existing);
                            });
                        return "El Encargado con ese codigo: " + existing.codencarg + " se cambio con exito";
                    }
                    else
                    {
                        return "El encargado con el codigo: " + existing.codencarg + " no existe";
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
                    var existing = db.Query<Encargado>("select * from Encargado").Where(c => c.codencarg == codigo).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codencarg, existing.nombre,existing.apellido,existing.sexo,existing.correo, "El encargado: " + existing.nombre + " se borro correctamente" };
                        db.RunInTransaction(() =>
                        {
                            db.Delete(existing);
                        });
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { codigo, "","","","", "El Encargado con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("No a digitado el codigo del encargado a borrar");
                string[] vec = new string[] { "", "", "","","","" };
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
                    var existing = db.Query<Encargado>("select * from Encargado").Where(c => c.codencarg == codigo).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codencarg, existing.nombre,existing.apellido,existing.correo,existing.sexo, "Encontrado" };
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { "", "","","","", "El encargado con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("Error debe digitar el codigo del encargado");
                string[] vec = new string[] { "", "","","","", "" };
                return vec;
            }
        }


        // Metodo Auxiliar
        public Boolean vacios(string codigo, string nombree, string apell, string sexoe, string email)
        {
            if (codigo == String.Empty)
            {
                MessageBox.Show("ERROR falta que Digite el codigo del encargado");
                return true;
            }
            else
            {
                if (nombree == String.Empty)
                {
                    MessageBox.Show("ERROR falta que digite el nombre del encargado");
                    return true;
                }
                else
                {
                    if (apell == String.Empty)
                    {
                        MessageBox.Show("ERROR falta que digite el apellido del encargado");
                        return true;
                    }
                    else
                    {
                        if (sexoe == String.Empty)
                        {
                            MessageBox.Show("ERROR falta que seleccione el sexo del encargado");
                            return true;
                        }
                        else
                        {
                            if (email == String.Empty)
                            {
                                MessageBox.Show("ERROR falta que digite el correo del encargado");
                                return true;
                            }
                            else { return false; }
                        }
                    }
                }
            }
        }
    }
}
