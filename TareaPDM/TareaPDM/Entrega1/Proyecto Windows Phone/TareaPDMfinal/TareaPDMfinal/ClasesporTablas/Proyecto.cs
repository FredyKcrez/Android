using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaPDMfinal.ClasesporTablas
{
    class Proyecto
    {
        [SQLite.PrimaryKey]
        public string codproyecto { get; set; }

        public string codencargado { get; set; }
        
        public string entidad { get; set; }
        
        public string tipoproyecto { get; set; }
        
        public string nombreproyecto { get; set; }
        
        public string cantalumnos { get; set; }
        
    }
}
