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

namespace TareaPDMfinal.Pivotes.TipoProyectos
{
    public partial class PivotTipoProyectoConsulta : PhoneApplicationPage
    {
        public PivotTipoProyectoConsulta()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");

        private void btnConsulta_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteTipoProyecto op = new MetodosSQLiteTipoProyecto();
            String[] res = op.Consulta(dbPath, editCodigo.Text);
            editNombre.Text = res[1];
            txtResultado.Text = res[2];

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
            var pers = db.Table<TipoProyecto>().Where(c => c.nombretp != null).ToList();
            listaTipoProyectos.ItemsSource = pers;
        }

        public void MostrarDatosUnicos(string res)
        {
            var db = new SQLiteConnection(dbPath);
            var pers = db.Table<TipoProyecto>().Where(c => c.codigotp == res).ToList();
            listaTipoProyectos.ItemsSource = pers;
        }

        private void listaTipoProyectos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            TipoProyecto items = (TipoProyecto)listaTipoProyectos.SelectedItem;
            editCodigo.Text = items.codigotp;
            editNombre.Text = items.nombretp;
            pivotPrincipal.SelectedItem = itemConsulta;
            txtResultado.Text = "Encontrado";
            MostrarDatosUnicos(items.codigotp);
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            editCodigo.Text = String.Empty;
            editNombre.Text = String.Empty;
            txtResultado.Text = String.Empty;
            MostrarDatos();
        }

        private void BtnMenu_OnClick(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuTipoProyecto.xaml?", UriKind.Relative));
        }


    }
}