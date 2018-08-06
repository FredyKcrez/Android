
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cr11005SQLiteWP8.ClasesPorTabla
{
    class Materia
    {
        [SQLite.PrimaryKey]
        public string CodMateria { get; set; }

        public string NomMateria { get; set; }

        public string UnidadesVal { get; set; }
    }
}
