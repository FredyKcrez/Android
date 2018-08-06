using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using System.IO;
using Windows.Storage;
using SQLite;
using TareaPDMfinal.MetodosSQLite;
using TareaPDMfinal.ClasesporTablas;

namespace TareaPDMfinal.Pivotes.Especialidades
{
    public partial class PivotEspecialidadConsulta : PhoneApplicationPage
    {
        public PivotEspecialidadConsulta()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");

        private void btnConsulta_OnClick(object sender, RoutedEventArgs e)
        {

            MetodosSQLiteEspecialidad op = new MetodosSQLiteEspecialidad();

            String[] res = op.Consulta(dbPath, editCodigo.Text);
            editNombre.Text = res[1];
            editCantidad_est.Text = res[2];
            txtResultado.Text = res[3];
            if (res[0] != string.Empty)
            {

                MostrarDatosUnicos(res[0]);
            }

            else
            {
                MostrarDatos();

            }

        }

        public void MostrarDatos()
        {

            var db = new SQLiteConnection(dbPath);

            var pers = db.Table<Especialidad>().Where(c => c.Nombre != null).ToList(); listaEspecialidades.ItemsSource = pers;

        }

        public void MostrarDatosUnicos(string res)
        {
            var db = new SQLiteConnection(dbPath);

            var pers = db.Table<Especialidad>().Where(c => c.Codigo == res).ToList();
            listaEspecialidades.ItemsSource = pers;

        }

        private void listaEspecialidades_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            Especialidad items = (Especialidad)listaEspecialidades.SelectedItem;
            editCodigo.Text = items.Codigo;
            editNombre.Text = items.Nombre;
            editCantidad_est.Text = items.Cantidad_est;
            pivotPrincipal.SelectedItem = itemConsulta;
            txtResultado.Text = "Encontrado";
            MostrarDatosUnicos(items.Codigo);

        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {

            editCodigo.Text = String.Empty;
            editNombre.Text = String.Empty;
            editCantidad_est.Text = String.Empty;
            txtResultado.Text = String.Empty;
            MostrarDatos();

        }

        private void BtnMenu_OnClick(object sender, RoutedEventArgs e)
        {

            NavigationService.Navigate(new Uri("/Menus/MenuEspecialidad.xaml?", UriKind.Relative));

        }


    }
}