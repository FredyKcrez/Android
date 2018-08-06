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

namespace TareaPDMfinal.Pivotes.TipoProyectos
{
    public partial class PivotTipoProyectoDelete : PhoneApplicationPage
    {
        public PivotTipoProyectoDelete()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");

        public void MostrarDatos()
        {
            var db = new SQLiteConnection(dbPath);
            var pers = db.Table<TipoProyecto>().Where(c => c.nombretp != null).ToList();
            listaTipoProyectos.ItemsSource = pers;
        }

        private void btnDelete_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteTipoProyecto op = new MetodosSQLiteTipoProyecto();
            String[] res = op.Delete(dbPath, editCodigo.Text);
            editCodigo.Text = res[0];
            editNombre.Text = res[1];
            txtResultado.Text = res[2];
            MostrarDatos();
        }

        private void listaTipoProyectos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            TipoProyecto items = (TipoProyecto)listaTipoProyectos.SelectedItem;
            editCodigo.Text = items.codigotp;
            editNombre.Text = items.nombretp;
            pivotPrincipal.SelectedItem = itemDelete;
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            editCodigo.Text = String.Empty;
            editNombre.Text = String.Empty;
            txtResultado.Text = String.Empty;
        }

        private void btnMenu_OnClick(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuTipoProyecto.xaml?", UriKind.Relative));
        }
    }
}