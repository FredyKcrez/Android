﻿#pragma checksum "C:\Users\Luis Morales\documents\visual studio 2012\Projects\TareaPDMfinal\TareaPDMfinal\Pivotes\Proyectos\PivotProyectoUpdate.xaml" "{406ea660-64cf-4c82-b6f0-42d48172a799}" "54E8B79B9D3EDEF977005869792B6B44"
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
    
    
    public partial class PivotProyectoUpdate : Microsoft.Phone.Controls.PhoneApplicationPage {
        
        internal System.Windows.Controls.Grid LayoutRoot;
        
        internal Microsoft.Phone.Controls.Pivot pivotPrincipal;
        
        internal Microsoft.Phone.Controls.PivotItem itemUpdate;
        
        internal System.Windows.Controls.TextBox editCodigop;
        
        internal System.Windows.Controls.TextBox editCodigoe;
        
        internal System.Windows.Controls.TextBox editEntidad;
        
        internal System.Windows.Controls.TextBox editTipo;
        
        internal System.Windows.Controls.TextBox editNombre;
        
        internal System.Windows.Controls.TextBox editCantidad;
        
        internal System.Windows.Controls.Button btnUpdate;
        
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
            System.Windows.Application.LoadComponent(this, new System.Uri("/TareaPDMfinal;component/Pivotes/Proyectos/PivotProyectoUpdate.xaml", System.UriKind.Relative));
            this.LayoutRoot = ((System.Windows.Controls.Grid)(this.FindName("LayoutRoot")));
            this.pivotPrincipal = ((Microsoft.Phone.Controls.Pivot)(this.FindName("pivotPrincipal")));
            this.itemUpdate = ((Microsoft.Phone.Controls.PivotItem)(this.FindName("itemUpdate")));
            this.editCodigop = ((System.Windows.Controls.TextBox)(this.FindName("editCodigop")));
            this.editCodigoe = ((System.Windows.Controls.TextBox)(this.FindName("editCodigoe")));
            this.editEntidad = ((System.Windows.Controls.TextBox)(this.FindName("editEntidad")));
            this.editTipo = ((System.Windows.Controls.TextBox)(this.FindName("editTipo")));
            this.editNombre = ((System.Windows.Controls.TextBox)(this.FindName("editNombre")));
            this.editCantidad = ((System.Windows.Controls.TextBox)(this.FindName("editCantidad")));
            this.btnUpdate = ((System.Windows.Controls.Button)(this.FindName("btnUpdate")));
            this.btnLimpiar = ((System.Windows.Controls.Button)(this.FindName("btnLimpiar")));
            this.txtResultado = ((System.Windows.Controls.TextBlock)(this.FindName("txtResultado")));
            this.btnMenu = ((System.Windows.Controls.Button)(this.FindName("btnMenu")));
            this.listaProyectos = ((Microsoft.Phone.Controls.LongListSelector)(this.FindName("listaProyectos")));
        }
    }
}

