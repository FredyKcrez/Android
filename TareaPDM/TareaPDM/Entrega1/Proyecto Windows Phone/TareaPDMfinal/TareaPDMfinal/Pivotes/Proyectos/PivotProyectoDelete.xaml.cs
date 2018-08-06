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

namespace TareaPDMfinal.Pivotes.Proyectos
{
    public partial class PivotProyectoDelete : PhoneApplicationPage
    {
        public PivotProyectoDelete()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        
    public void MostrarDatos()
        {
            var db = new SQLiteConnection(dbPath); 
            var pers = db.Table<Proyecto>().Where(c => c.nombreproyecto != null).ToList(); 
            listaProyectos.ItemsSource = pers;
        }


    private void BtnDelete_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteProyecto op = new MetodosSQLiteProyecto();
            String[] res = op.Delete(dbPath, editCodigop.Text); 
            editCodigop.Text = res[0]; 
            editCodigoe.Text = res[1]; 
            editEntidad.Text = res[2];
            editTipo.Text = res[3];
            editNombre.Text = res[4];
            editCantidad.Text = res[5];
            txtResultado.Text = res[6]; 
            MostrarDatos();
        }

    private void listaProyectos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            Proyecto items = (Proyecto)listaProyectos.SelectedItem;
            editCodigop.Text = items.codproyecto; 
            editCodigoe.Text = items.codencargado; 
            editEntidad.Text = items.entidad;
            editTipo.Text = items.tipoproyecto;
            editNombre.Text = items.nombreproyecto;
            editCantidad.Text = items.cantalumnos;
            pivotPrincipal.SelectedItem = itemDelete;
        }

    private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            editCodigop.Text = String.Empty; 
            editCodigoe.Text = String.Empty; 
            editEntidad.Text = String.Empty;
            editTipo.Text = String.Empty;
            editNombre.Text = String.Empty;
            editCantidad.Text = String.Empty;     
        txtResultado.Text = String.Empty;
        }


    private void BtnMenu_OnClick(object sender, RoutedEventArgs e) 
    { 
        NavigationService.Navigate(new Uri("/Menus/MenuProyecto.xaml?", UriKind.Relative)); 
    }

  }
}