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

namespace TareaPDMfinal.Pivotes.Modalidad
{
    public partial class PivotModalidadConsulta : PhoneApplicationPage
    {
        public PivotModalidadConsulta()
        {
            InitializeComponent();
            MostrarDatos();
        }


        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        
    private void btnConsulta_OnClick(object sender, RoutedEventArgs e) 
    { 
        MetodosSQLiteModalidad op = new MetodosSQLiteModalidad();
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
        var pers = db.Table<TareaPDMfinal.ClasesporTablas.Modalidad>().Where(c => c.nombmodalidad != null).ToList(); 
        listaModalidades.ItemsSource = pers;
    } 
        
    public void MostrarDatosUnicos(string res) 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<TareaPDMfinal.ClasesporTablas.Modalidad>().Where(c => c.codmodalidad == res).ToList(); 
        listaModalidades.ItemsSource = pers; 
    } 
        
    private void listaModalidades_SelectionChanged(object sender, SelectionChangedEventArgs e) 
    { 
        TareaPDMfinal.ClasesporTablas.Modalidad items = (TareaPDMfinal.ClasesporTablas.Modalidad)listaModalidades.SelectedItem;
        editCodigo.Text = items.codmodalidad; 
        editNombre.Text = items.nombmodalidad;
        pivotPrincipal.SelectedItem = itemConsulta; 
        txtResultado.Text = "Encontrado"; 
        MostrarDatosUnicos(items.codmodalidad);
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
        NavigationService.Navigate(new Uri("/Menus/MenuModalidad.xaml?", UriKind.Relative)); 
    }


    }
}