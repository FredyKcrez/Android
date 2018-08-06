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

namespace TareaPDMfinal.Pivotes.Encargados
{
    public partial class PivotEncargadoDelete : PhoneApplicationPage
    {
        public PivotEncargadoDelete()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 
        public string sexo = string.Empty;
    
    public void MostrarDatos() 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<Encargado>().Where(c => c.nombre != null).ToList(); 
        listaEncargados.ItemsSource = pers;
    }

    private void BtnDelete_OnClick(object sender, RoutedEventArgs e) 
    { 
        MetodosSQLiteEncargado op = new MetodosSQLiteEncargado();
        String[] res = op.Delete(dbPath, editCodigo.Text); 
        editCodigo.Text = res[0]; 
        editNombre.Text = res[1]; 
        editApellido.Text = res[2];
        editCorreo.Text = res[3];
        txtResultado.Text = res[5]; 
        MostrarDatos(); 
    }

    private void listaEncargados_SelectionChanged(object sender, SelectionChangedEventArgs e) 
    { 
        Encargado items = (Encargado)listaEncargados.SelectedItem;
        editCodigo.Text = items.codencarg; 
        editNombre.Text = items.nombre; 
        editApellido.Text = items.apellido;
        editCorreo.Text = items.correo;
        pivotPrincipal.SelectedItem = itemDelete;
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