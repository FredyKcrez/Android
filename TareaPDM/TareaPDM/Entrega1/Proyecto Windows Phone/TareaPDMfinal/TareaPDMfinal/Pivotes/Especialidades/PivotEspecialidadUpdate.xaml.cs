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
    public partial class PivotEspecialidadUpdate : PhoneApplicationPage
    {
        public PivotEspecialidadUpdate()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");


        public void MostrarDatos()
        {
            var db = new SQLiteConnection(dbPath);

            var pers = db.Table<Especialidad>().Where(c => c.Nombre != null).ToList();
            listaEspecialidades.ItemsSource = pers;
        }

        private void listaEspecialidades_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

            Especialidad items = (Especialidad)listaEspecialidades.SelectedItem;

            editCodigo.Text = items.Codigo;
            editNombre.Text = items.Nombre;
            editCantidad_est.Text = items.Cantidad_est;

            pivotPrincipal.SelectedItem = itemUpdate;

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

        private void BtnUpdate_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteEspecialidad prueba = new MetodosSQLiteEspecialidad();

            String res2 = prueba.Update(dbPath, editCodigo.Text, editNombre.Text, editCantidad_est.Text);

            txtResultado.Text = res2;
            MostrarDatos();
        }


    }
}