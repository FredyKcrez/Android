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

namespace TareaPDMfinal.Pivotes.Proyectos
{
    public partial class PivotProyectoUpdate : PhoneApplicationPage
    {
        public PivotProyectoUpdate()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1");

    private void BtnUpdate_OnClick(object sender, RoutedEventArgs e) 
    { 
        MetodosSQLiteProyecto prueba = new MetodosSQLiteProyecto();
        String res2 = prueba.Update(dbPath, editCodigop.Text, editCodigoe.Text, editEntidad.Text, editTipo.Text, editNombre.Text, editCantidad.Text); 
        txtResultado.Text = res2;
        MostrarDatos();
    } 
        
    public void MostrarDatos() 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<Proyecto>().Where(c => c.nombreproyecto != null).ToList(); 
        listaProyectos.ItemsSource = pers; 
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
        pivotPrincipal.SelectedItem = itemUpdate;
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