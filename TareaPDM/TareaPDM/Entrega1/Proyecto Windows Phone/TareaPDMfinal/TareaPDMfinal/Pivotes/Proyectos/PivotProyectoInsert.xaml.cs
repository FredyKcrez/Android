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

namespace TareaPDMfinal.Pivotes.Proyectos
{
    public partial class PivotProyectoInsert : PhoneApplicationPage
    {
        public PivotProyectoInsert()
        {
            InitializeComponent();
            MostrarDatos();
        }

        string dbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, "db.sqlite1"); 

    private void BtnInsert_OnClick(object sender, RoutedEventArgs e)
        {
            MetodosSQLiteProyecto op = new MetodosSQLiteProyecto();
            String res = op.Insert(dbPath, editCodigop.Text, editCodigoe.Text, editEntidad.Text, editTipop.Text, editNombrep.Text, editCantidad.Text); 
            txtResultado.Text = res; MostrarDatos();
        }

    public void MostrarDatos() 
    { 
        var db = new SQLiteConnection(dbPath); 
        var pers = db.Table<Proyecto>().Where(c => c.nombreproyecto != null).ToList(); 
        listaProyectos.ItemsSource = pers; 
    }

    private void btnLimpiar_Click(object sender, RoutedEventArgs e) 
    { 
        editCodigop.Text = String.Empty; 
        editCodigoe.Text = String.Empty; 
        editEntidad.Text = String.Empty;
        editTipop.Text = String.Empty;
        editNombrep.Text = String.Empty;
        editCantidad.Text = String.Empty;
        txtResultado.Text = String.Empty; 
    }

    private void BtnMenu_OnClick(object sender, RoutedEventArgs e) 
    { 
        NavigationService.Navigate(new Uri("/Menus/MenuProyecto.xaml?", UriKind.Relative)); 
    }

  }
}