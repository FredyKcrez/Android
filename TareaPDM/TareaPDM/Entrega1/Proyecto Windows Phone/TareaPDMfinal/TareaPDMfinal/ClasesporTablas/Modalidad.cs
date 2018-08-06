using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaPDMfinal.ClasesporTablas
{
    class Modalidad
    {
        [SQLite.PrimaryKey]
        public string codmodalidad { get; set; }

        public string nombmodalidad { get; set; }
    }
}
