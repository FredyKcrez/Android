using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cr11005SQLiteWP8.ClasesPorTabla
{
    class Nota
    {
        [SQLite.PrimaryKey]
        public string Carnet { get; set; }

        public string Codigo { get; set; }

        public string Ciclo { get; set; }

        public string NotaFinal { get; set; }
    }
}
