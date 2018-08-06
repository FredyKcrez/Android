using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SQLite; 
using System.Windows; 
using TareaPDMfinal.ClasesporTablas;

namespace TareaPDMfinal.MetodosSQLite
{
    class MetodosSQLiteProyecto
    {

        //Constructor 
        public MetodosSQLiteProyecto() { }

        // ********** METODO INSERT *********************** // 
        public String Insert(string dbPath, string codigop, string codigoe, string enty, string tipop, string nombrep, string canta)
        {
            if (vacios(dbPath, codigop, codigoe, enty, tipop, nombrep, canta) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Proyecto>("select * from Proyecto").Where(c => c.codproyecto == codigop).FirstOrDefault();
                    if (existing == null)
                    {
                        db.RunInTransaction(() =>
                          {
                              db.Insert(new Proyecto()
                              {
                                  codproyecto = codigop,
                                  codencargado = codigoe,
                                  entidad = enty,
                                  tipoproyecto = tipop,
                                  nombreproyecto = nombrep,
                                  cantalumnos = canta,
                              });
                          });
                        return "Se guardo con exito";
                    }
                    else
                    {
                        return "Ya hay un proyecto con es codigo";
                    }
                }
            }
            else return "";
        }


        //**************************************************//
        // ********** METODO UPDATE *********************** // 
        public string Update(string dbPath, string codigop, string codigoe, string enty, string tipop, string nombrep, string canta)
        {
            if (vacios(dbPath, codigop, codigoe, enty, tipop, nombrep, canta) == false)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Proyecto>("select * from Proyecto").Where(c => c.codproyecto == codigop).FirstOrDefault();
                    if (existing != null)
                    {
                        //sustituira en la base segun el codigo encontrado los datos que esten el edit 
                        existing.codproyecto = codigop;
                        existing.codencargado = codigoe;
                        existing.entidad = enty;
                        existing.tipoproyecto = tipop;
                        existing.nombreproyecto = nombrep;
                        existing.cantalumnos = canta;
                        db.RunInTransaction(() =>
                        {
                            db.Update(existing);
                        });
                        return "El proyecto con ese codigo : " + existing.codproyecto + " se cambio con exito";
                    }
                    else
                    {
                        return "El proyecto con ese codigo no existe";
                    }
                }
            }
            else
            {
                return "";
            }
        }


        // ************************************************ //
        // ********** METODO DELETE *********************** // 
        public string[] Delete(string dbPath, string codigop)
        {
            if (codigop != String.Empty)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Proyecto>("select * from Proyecto").Where(c => c.codproyecto == codigop).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] { existing.codproyecto, existing.codencargado, existing.entidad, existing.tipoproyecto, existing.nombreproyecto, existing.cantalumnos, "El proyecto anterior se borro correctamente" };
                        db.RunInTransaction(() =>
                        {
                            db.Delete(existing);
                        });
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { codigop, "", "", "", "", "", "El Usuario con ese Carnet no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("No a digitado el Carnet a borrar");
                string[] vec = new string[] { "", "", "", "", "", "", "" };
                return vec;
            }
        }


        // ************************************************** //        
        // ********** METODO CONSULTA *********************** // 
        public string[] Consulta(string dbPath, string codigop)
        {
            if (codigop != String.Empty)
            {
                using (var db = new SQLiteConnection(dbPath))
                {
                    var existing = db.Query<Proyecto>("select * from Proyecto").Where(c => c.codproyecto == codigop).FirstOrDefault();
                    if (existing != null)
                    {
                        string[] vec = new string[] 
                        { 
                            existing.codproyecto, existing.codencargado, existing.entidad, existing.tipoproyecto, existing.nombreproyecto, existing.cantalumnos, "Encontrado" };
                        return vec;
                    }
                    else
                    {
                        string[] vec = new string[] { "", "", "", "", "", "", "El proyecto con ese codigo no existe" };
                        return vec;
                    }
                }
            }
            else
            {
                MessageBox.Show("ERROR debe digitar el codigo del proyecto");
                string[] vec = new string[] { "", "", "", "", "", "", "" };
                return vec;
            }
        }


        // ************************************************** //
        // Metodo Auxiliar 
        public Boolean vacios(string dbPath, string codigop, string codigoe, string enty, string tipop, string nombrep, string canta)
        {
            if (codigop == String.Empty) { MessageBox.Show("ERROR falta que digite el codigo de proyecto"); return true; }
            else
            {
                if (codigoe == String.Empty) { MessageBox.Show("ERROR falta que digite el codigo del encarg."); return true; }
                else
                {
                    if (enty == String.Empty) { MessageBox.Show("ERROR falta que digite el nombre de la entidad"); return true; }
                    else
                    {
                        if (tipop == String.Empty) { MessageBox.Show("ERROR falta que digite el tipo de proyecto"); return true; }
                        else
                        {
                            if (nombrep == String.Empty) { MessageBox.Show("ERROR falta que digite el nombre del proyecto"); return true; }
                            else
                            {
                                if (canta == String.Empty) { MessageBox.Show("ERROR falta que digite la cantidad de alumnos"); return true; }
                                else { return false; }
                            }
                        }
                    }
                }
            }
        }
    }
}
