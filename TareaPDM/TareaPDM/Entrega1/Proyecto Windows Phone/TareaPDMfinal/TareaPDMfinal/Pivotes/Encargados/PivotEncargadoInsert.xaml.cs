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

namespace TareaPDMfinal.Pivotes.Encargados
{
    public partial class PivotEncargadoInsert : PhoneApplicationPage
    {
        public PivotEncargadoInsert()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        public string sexo = string.Empty;

    private void BtnInsert_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteEncargado op = new MetodosSQLiteEncargado();
            String res = op.Insert(dbPath, editCodigo.Text, editNombre.Text, editApellido.Text, sexo,editCorreo.Text); 
            txtResultado.Text = res; 
            MostrarDatos();
        }

    public void MostrarDatos() { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<TareaPDMfinal.ClasesporTablas.Encargado>().Where(c => c.nombre != null).ToList(); 
        listaEncargados.ItemsSource = pers; 
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