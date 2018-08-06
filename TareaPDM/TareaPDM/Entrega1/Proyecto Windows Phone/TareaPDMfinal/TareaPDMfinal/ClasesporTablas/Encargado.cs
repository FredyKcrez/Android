using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaPDMfinal.ClasesporTablas
{
    class Encargado
    {
        [SQLite.PrimaryKey]
        public string codencarg { get; set; }

        public string nombre { get; set; }

        public string apellido { get; set; }
        
        public string sexo { get; set; }

        public string correo { get; set; }
    }
}
