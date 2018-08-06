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
    public partial class PivotTipoProyectoUpdate : PhoneApplicationPage
    {
        public PivotTipoProyectoUpdate()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");


        private void BtnUpdate_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteTipoProyecto prueba = new MetodosSQLiteTipoProyecto();
            String res2 = prueba.Update(dbPath, editCodigo.Text, editNombre.Text);
            txtResultado.Text = res2;
            MostrarDatos();
        }

        public void MostrarDatos()
        {
            var db = new SQLiteConnection(dbPath);
            var pers = db.Table<TipoProyecto>().Where(c => c.nombretp != null).ToList();
            listaTipoProyectos.ItemsSource = pers;
        }

        private void listaTipoProyectos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            TipoProyecto items = (TipoProyecto)listaTipoProyectos.SelectedItem;
            editCodigo.Text = items.codigotp;
            editNombre.Text = items.nombretp;
            pivotPrincipal.SelectedItem = itemUpdate;
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            editCodigo.Text = String.Empty;
            editNombre.Text = String.Empty;
            txtResultado.Text = String.Empty;
        }

        private void BtnMenu_OnClick(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuTipoProyecto.xaml?", UriKind.Relative));
        }


    }
}