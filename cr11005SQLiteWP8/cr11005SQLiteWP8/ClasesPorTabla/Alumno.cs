using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cr11005SQLiteWP8.ClasesPorTabla
{
    class Alumno
    {
        [SQLite.PrimaryKey]
        public string Carnet { get; set; }

        public string Nombre { get; set; }

        public string Apellido { get; set; }

        public string Sexo { get; set; }
    }
}
