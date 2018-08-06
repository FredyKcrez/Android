using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaPDMfinal.ClasesporTablas
{
    class Especialidad
    {
        [SQLite.PrimaryKey]
        public string Codigo { get; set; }
        public string Nombre { get; set; }
        public string Cantidad_est { get; set; }
    }
}
