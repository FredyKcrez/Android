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
    class MetodosSQLiteModalidad
    {
        //Constructor 
        public MetodosSQLiteModalidad() { }

        //Metodo Insertar
        public String Insert(string dbPath, string codigomod, string nombremod)
        {
            if (vacios(codigomod, nombremod) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Modalidad>("select * from Modalidad").Where(c => c.codmodalidad == codigomod).FirstOrDefault();
                    if (existing == null)
                    {
                        db.RunInTransaction(() =>
                        {
                            db.Insert(new Modalidad()
                            {

                                codmodalidad = codigomod,
                                nombmodalidad = nombremod,
                            });
                        });
                        return "Se Guardo con exito";
                    }
                    else
                    {
                        return "Ya hay una Modalidad con ese codigo";
                    }
                }
            }
            else return "";
        }


        //***********METODO UPDATE**************//
        public string Update(string dbPath, string codigomod, string nombremod)
        {
            if (vacios(codigomod, nombremod) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    string auxCodigo = codigomod;
                    var existing = db.Query<Modalidad>("select * from Modalidad").Where(c => c.codmodalidad == auxCodigo).FirstOrDefault();
                    if (existing != null)
                    {
                        existing.nombmodalidad = nombremod;
                        db.RunInTransaction(() =>
                            {
                                db.Update(existing);
                            });
                        return "La Modalidad con el codigo: " + existing.codmodalidad + " se cambio con exito";
                    }
                    else
                    {
                        return "La modalidad con el codigo: " + existing.codmodalidad + " no existe";
                    }
                }
            }
            else
                return "";
        }


        // ********** METODO DELETE *********************** //
        public string[] Delete(string dbPath, string codigomodalidad)
        {
            if (codigomodalidad != String.Empty)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Modalidad>("select * from Modalidad").Where(c => c.codmodalidad == codigomodalidad).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codmodalidad, existing.nombmodalidad, "La Modalidad anterior se borro correctamente" };
                        db.RunInTransaction(() =>
                        {
                            db.Delete(existing);
                        });
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { codigomodalidad, "", "La modalidad con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("No a digitado el codigo de la modalidad a borrar");
                string[] vec = new string[] { "", "", "" };
                return vec;
            }
        }


        // ********** METODO CONSULTA *********************** //
        public string[] Consulta(string dbPath, string codigomod)
        {
            if (codigomod != String.Empty)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Modalidad>("select * from Modalidad").Where(c => c.codmodalidad == codigomod).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codmodalidad, existing.nombmodalidad, "Encontrado" };
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { "", "", "La Modalidad con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("Error debe digitar el codigo de la modalidad");
                string[] vec = new string[] { "", "", "" };
                return vec;
            }
        }


        // Metodo Auxiliar
        public Boolean vacios(string codigomod, string nombremod)
        {
            if (codigomod == String.Empty)
            {
                MessageBox.Show("Error falta que Digite el codigo de la modalidad");
                return true;
            }
            else
            {
                if (nombremod == String.Empty)
                {
                    MessageBox.Show("ERROR falta que digite el nombre de la modalidad");
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

  }

