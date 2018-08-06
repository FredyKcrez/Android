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
using TareaPDMfinal.MetodosSQLite;
using TareaPDMfinal.ClasesporTablas;

namespace TareaPDMfinal.Pivotes.TipoProyectos
{
    public partial class PivotTipoProyectoInsert : PhoneApplicationPage
    {
        public PivotTipoProyectoInsert()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");


        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            editCodigo.Text = String.Empty;
            editNombre.Text = String.Empty;
            txtResultado.Text = String.Empty;

        }

        public void MostrarDatos()
        {
            var db = new SQLiteConnection(dbPath);
            var pers = db.Table<TipoProyecto>().Where(c => c.codigotp != null).ToList();
            listaTipoProyectos.ItemsSource = pers;
        }

        private void BtnMenu_OnClick(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Menus/MenuTipoProyecto.xaml?", UriKind.Relative));
        }


        private void btnInsert_Click_1(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteTipoProyecto op = new MetodosSQLiteTipoProyecto();
            String resp = op.Insert(dbPath, editCodigo.Text, editNombre.Text);
            txtResultado.Text = resp;
            MostrarDatos();

        } 



    }
}