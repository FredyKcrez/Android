﻿#pragma checksum "C:\Users\Luis Morales\documents\visual studio 2012\Projects\TareaPDMfinal\TareaPDMfinal\Pivotes\Proyectos\PivotProyectoInsert.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "DB108A7CF4C7EF712506487A23812DEB"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.34014
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using Microsoft.Phone.Controls;
using System;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Interop;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Resources;
using System.Windows.Shapes;
using System.Windows.Threading;


namespace TareaPDMfinal.Pivotes.Proyectos {
    
    
    public partial class PivotProyectoInsert : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal Microsoft.Phone.Controls.Pivot pivotPrincipal;
        
        internal Microsoft.Phone.Controls.PivotItem itemInsertar;
        
        internal System.Windows.Controls.TextBox editCodigop;
        
        internal System.Windows.Controls.TextBox editCodigoe;
        
        internal System.Windows.Controls.TextBox editEntidad;
        
        internal System.Windows.Controls.TextBox editTipop;
        
        internal System.Windows.Controls.TextBox editNombrep;
        
        internal System.Windows.Controls.TextBox editCantidad;
        
        internal System.Windows.Controls.Button btnInsert;
        
        internal System.Windows.Controls.Button btnLimpiar;
        
        internal System.Windows.Controls.TextBlock txtResultado;
        
        internal System.Windows.Controls.Button btnMenu;
        
        internal Microsoft.Phone.Controls.LongListSelector listaProyectos;
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Windows.Application.LoadComponent(this, new System.Uri("/TareaPDMfinal;component/Pivotes/Proyectos/PivotProyectoInsert.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.pivotPrincipal = ((Microsoft.Phone.Controls.Pivot)(this.FindName("pivotPrincipal")));
            this.itemInsertar = ((Microsoft.Phone.Controls.PivotItem)(this.FindName("itemInsertar")));
            this.editCodigop = ((System.Windows.Controls.TextBox)(this.FindName("editCodigop")));
            this.editCodigoe = ((System.Windows.Controls.TextBox)(this.FindName("editCodigoe")));
            this.editEntidad = ((System.Windows.Controls.TextBox)(this.FindName("editEntidad")));
            this.editTipop = ((System.Windows.Controls.TextBox)(this.FindName("editTipop")));
            this.editNombrep = ((System.Windows.Controls.TextBox)(this.FindName("editNombrep")));
            this.editCantidad = ((System.Windows.Controls.TextBox)(this.FindName("editCantidad")));
            this.btnInsert = ((System.Windows.Controls.Button)(this.FindName("btnInsert")));
            this.btnLimpiar = ((System.Windows.Controls.Button)(this.FindName("btnLimpiar")));
            this.txtResultado = ((System.Windows.Controls.TextBlock)(this.FindName("txtResultado")));
            this.btnMenu = ((System.Windows.Controls.Button)(this.FindName("btnMenu")));
            this.listaProyectos = ((Microsoft.Phone.Controls.LongListSelector)(this.FindName("listaProyectos")));
        }
    }
}

