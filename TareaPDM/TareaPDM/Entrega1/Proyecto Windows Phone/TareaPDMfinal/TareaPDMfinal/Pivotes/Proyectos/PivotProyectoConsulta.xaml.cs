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
    public partial class PivotProyectoConsulta : PhoneApplicationPage
    {
        public PivotProyectoConsulta()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        
    private void btnConsulta_OnClick(object sender, RoutedEventArgs e) 
    { 
        MetodosSQLiteProyecto op = new MetodosSQLiteProyecto();
        String[] res = op.Consulta(dbPath, editCodigop.Text); 
        editCodigoe.Text = res[1]; 
        editEntidad.Text = res[2];
        editTipo.Text = res[3];
        editNombrep.Text = res[4];
        editCantidad.Text = res[5];
        txtResultado.Text = res[6]; 
        
        if (res[0] != string.Empty) 
        { 
            MostrarDatosUnicos(res[0]); 
        } 
        else { MostrarDatos(); }
    } 
        
    public void MostrarDatos() 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<Proyecto>().Where(c => c.nombreproyecto != null).ToList(); 
        listaProyectos.ItemsSource = pers;
    } 
        
    public void MostrarDatosUnicos(string res) 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<Proyecto>().Where(c => c.codproyecto == res).ToList(); 
        listaProyectos.ItemsSource = pers; 
    } 
        
    private void listaProyectos_SelectionChanged(object sender, SelectionChangedEventArgs e) 
    { 
        Proyecto items = (Proyecto)listaProyectos.SelectedItem;
        editCodigop.Text = items.codproyecto; 
        editCodigoe.Text = items.codencargado; 
        editEntidad.Text = items.entidad;
        editTipo.Text = items.tipoproyecto;
        editNombrep.Text = items.nombreproyecto;
        editCantidad.Text = items.cantalumnos;
        pivotPrincipal.SelectedItem = itemConsulta; 
        txtResultado.Text = "Encontrado"; 
        MostrarDatosUnicos(items.codproyecto);
    } 
        
    private void btnLimpiar_Click(object sender, RoutedEventArgs e) 
    { 
        editCodigop.Text = String.Empty; 
        editCodigoe.Text = String.Empty; 
        editEntidad.Text = String.Empty;
        editTipo.Text = String.Empty;
        editNombrep.Text = String.Empty;
        editCantidad.Text = String.Empty;
        txtResultado.Text = String.Empty; 
        MostrarDatos(); 
    }

    private void BtnMenu_OnClick(object sender, RoutedEventArgs e) 
    { 
        NavigationService.Navigate(new Uri("/Menus/MenuProyecto.xaml?", UriKind.Relative)); 
    }
  }
}