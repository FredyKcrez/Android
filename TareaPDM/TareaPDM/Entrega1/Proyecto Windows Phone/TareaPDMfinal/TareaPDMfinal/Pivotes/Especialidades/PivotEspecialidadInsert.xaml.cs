using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using SQLite;
using System.IO;
using Windows.Storage;
using TareaPDMfinal.ClasesporTablas;
using TareaPDMfinal.MetodosSQLite;

namespace TareaPDMfinal.Pivotes.Especialidades
{
    public partial class PivotEspecialidadInsert : PhoneApplicationPage
    {
        public PivotEspecialidadInsert()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");
        public string sexo = string.Empty;

        private void BtnInsert_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteEspecialidad op = new MetodosSQLiteEspecialidad();
            String res = op.Insert(dbPath, editCodigo.Text, editNombre.Text, editCantidad_est.Text);
            txtResultado.Text = res;
            MostrarDatos();
        }
        public void MostrarDatos()
        {
            var db = new SQLiteConnection(dbPath);
            var pers = db.Table<Especialidad>().Where(c => c.Nombre != null).ToList();
            listaEspecialidades.ItemsSource = pers;
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            editCodigo.Text = String.Empty;
            editNombre.Text = String.Empty;
            editCantidad_est.Text = String.Empty;
            txtResultado.Text = String.Empty;
        }


        private void BtnMenu_OnClick(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuEspecialidad.xaml?", UriKind.Relative));
        }
    }
}