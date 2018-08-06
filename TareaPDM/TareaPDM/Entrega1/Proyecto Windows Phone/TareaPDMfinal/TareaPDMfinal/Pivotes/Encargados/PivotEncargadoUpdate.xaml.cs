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

namespace TareaPDMfinal.Pivotes.Encargados
{
    public partial class PivotEncargadoUpdate : PhoneApplicationPage
    {
        public PivotEncargadoUpdate()
        {
            InitializeComponent();
            MostrarDatos();
        }


        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        public string sexo = string.Empty;

    private void BtnUpdate_OnClick(object sender, RoutedEventArgs e) 
    { 
        MetodosSQLiteEncargado prueba = new MetodosSQLiteEncargado();
        String res2 = prueba.Update(dbPath, editCodigo.Text, editNombre.Text, editApellido.Text, sexo, editCorreo.Text); 
        txtResultado.Text = res2;
        MostrarDatos();
    } 
    
    public void MostrarDatos() 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<Encargado>().Where(c => c.nombre != null).ToList(); 
        listaEncargados.ItemsSource = pers; 
    }

    private void listaEncargados_SelectionChanged(object sender, SelectionChangedEventArgs e)
    {
        Encargado items = (Encargado)listaEncargados.SelectedItem;
        editCodigo.Text = items.codencarg; 
        editNombre.Text = items.nombre;
        editApellido.Text = items.apellido;
        editCorreo.Text = items.correo;
        pivotPrincipal.SelectedItem = itemUpdate;
    }

    private void btnLimpiar_Click(object sender, RoutedEventArgs e) 
    { 
        editCodigo.Text = String.Empty; 
        editNombre.Text = String.Empty; 
        editApellido.Text = String.Empty;
        editCorreo.Text = String.Empty;
        txtResultado.Text = String.Empty; 
    }

    private void radioHombre_Checked(object sender, RoutedEventArgs e) 
    { 
        sexo = "Hombre"; 
    }

    private void radioMujer_Checked(object sender, RoutedEventArgs e) 
    { 
        sexo = "Mujer"; 
    } 
    
    private void BtnMenu_OnClick(object sender, RoutedEventArgs e) 
    { 
        NavigationService.Navigate(new Uri("/Menus/MenuEncargado.xaml?", UriKind.Relative)); 
    }

  }
}