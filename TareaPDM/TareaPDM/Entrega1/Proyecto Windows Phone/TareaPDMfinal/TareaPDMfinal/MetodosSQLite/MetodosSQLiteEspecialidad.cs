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
    class MetodosSQLiteEspecialidad
    {

        //Constructor

        public MetodosSQLiteEspecialidad()
        {
        }

        // ********** METODO INSERT *********************** //

        public String Insert(string dbPath, string codigo, string nombre, string cantidad_est)
        {

            if (vacios(codigo, nombre, cantidad_est) == false)
            {

                using (var db = new SQLiteConnection(dbPath))
                {

                    var existing = db.Query<Especialidad>("select * from Especialidad").Where(c => c.Codigo == codigo).FirstOrDefault();

                    if (existing == null)
                    {

                        db.RunInTransaction(() =>
                        {
                            db.Insert(new Especialidad()

                            {

                                Codigo = codigo,
                                Nombre = nombre,
                                Cantidad_est = cantidad_est,

                            });

                        });

                        return "Se Guardo con exito";

                    }
                    else
                    {

                        return "Ya hay un Especialidad con ese Codigo";

                    }

                }

            }

            else
                return "";

        }
        //**************************************************//

        // ********** METODO UPDATE *********************** //

        public string Update(string dbPath, string codigo, string nombre, string cantidad_est)
        {
            if (vacios(codigo, nombre, cantidad_est) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {

                    string auxCodigo = codigo;
                    var existing = db.Query<Especialidad>("select * from Especialdiad").Where(c => c.Codigo == auxCodigo).FirstOrDefault();
                    if (existing != null)
                    {
                        //sustituira en la base segun el Codigo encontrado los datos que esten el edit

                        existing.Nombre = nombre;
                        existing.Cantidad_est = cantidad_est;
                        db.RunInTransaction(() =>
                        {
                            db.Update(existing);
                        });
                        return "La Especialidad con ese codigo : " + existing.Codigo + " se cambio con exito";
                    }
                    else
                    {
                        return "La Especialidad con ese Codigo no existe";
                    }

                }
            }
            else
                return "";
        }

        // ************************************************ //



        // ********** METODO DELETE ********************* // 
        public string[] Delete(string dbPath, string codigo)
        {
            if (codigo != String.Empty)
            {

                using (var db = new SQLiteConnection(dbPath))
                {

                    var existing = db.Query<Especialidad>("select * from Especialidad").Where(c => c.Codigo == codigo).FirstOrDefault();

                    if (existing != null)
                    {

                        string[] vec = new string[] { existing.Codigo, existing.Nombre, existing.Cantidad_est, "La Especialidad anterior se borro correctamente" };

                        db.RunInTransaction(() =>
                        {
                            db.Delete(existing);

                        });

                        return vec;

                    }

                    else
                    {
                        string[] vec = new string[] { codigo, "", "", "La Especialidad con ese Codigo no existe" };

                        return vec;
                    }

                }

            }
            else
            {

                MessageBox.Show("No a digitado el Codigo a borrar"); string[] vec = new string[] { "", "", "" }; return vec;

            }

        }
        //************************************************** // 

        //********** METODO CONSULTA *********************** // 

        public string[] Consulta(string dbPath, string codigo)
        {
            if (codigo != String.Empty)
            {

                using (var db = new SQLiteConnection(dbPath))
                {

                    var existing = db.Query<Especialidad>("select * from Especialidad").Where(c => c.Codigo == codigo).FirstOrDefault();

                    if (existing != null)
                    {

                        string[] vec = new string[] { existing.Codigo, existing.Nombre, existing.Cantidad_est, "Encontrado" };

                        return vec;

                    }
                    else
                    {




                        string[] vec = new string[] { "", "", "", "La Especialidad con ese codigo no existe" };

                        return vec;

                    }

                }

            }

            else
            {

                MessageBox.Show("ERROR debe digitar el Codigo"); string[] vec = new string[] { "", "", "", "" }; return vec;

            }
        }

        // Metodo Auxiliar
        public Boolean vacios(string codigo, string nombre, string cantidad_est)
        {

            if (codigo == String.Empty)
            {

                MessageBox.Show("ERROR falta que Digite el Codigo");
                return true;

            }
            else
            {

                if (nombre == String.Empty)
                {

                    MessageBox.Show("ERROR falta que Digite el Nombre"); return true;
                }

                else
                {
                    if (cantidad_est == String.Empty)
                    {

                        MessageBox.Show("ERROR falta que Digite la Cantidad de Estudiantes"); return true;
                    }

                    else
                    {

                        return false;
                    }

                }

            }



        } 

    }
}
