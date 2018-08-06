using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaPDMfinal.ClasesporTablas
{
    class TipoProyecto
    {
        [SQLite.PrimaryKey]
        public string codigotp { get; set; }

        public string nombretp { get; set; }
    }
}
