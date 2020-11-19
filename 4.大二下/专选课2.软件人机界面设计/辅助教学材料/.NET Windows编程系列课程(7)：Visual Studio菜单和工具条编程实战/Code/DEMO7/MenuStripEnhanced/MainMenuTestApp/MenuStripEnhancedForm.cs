using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace MainMenuTestApp
{
    public partial class MenuStripEnhancedForm : Form
    {
        public MenuStripEnhancedForm()
        {
            InitializeComponent();
        }

        private void MenuStripEnhanced_Load( object sender, EventArgs e )
        {
            menuStripEnhanced1.LoadDynamicMenu();
        }

        private void MenuItemOnClick_LoadFileXMLAnonymous( object sender, EventArgs e )
        {
            menuStripEnhanced1.XmlPath = System.IO.Path.Combine( Application.StartupPath, "MenuAnonymous.xml" );
            menuStripEnhanced1.LoadDynamicMenu();
        }

        private void MenuItemOnClick_LoadFileXMLAdministrator( object sender, EventArgs e )
        {
            menuStripEnhanced1.XmlPath = System.IO.Path.Combine( Application.StartupPath, "MenuAdministrator.xml" );
            menuStripEnhanced1.LoadDynamicMenu();
        }

        private void MenuItemOnClick_LoadResourceXML( object sender, EventArgs e )
        {
            System.Xml.XmlTextReader reader = new System.Xml.XmlTextReader( GetEmbeddedFile( System.Reflection.Assembly.GetExecutingAssembly().GetName().Name, "MenuEmbeddedResource.xml" ) );

            menuStripEnhanced1.LoadDynamicMenu( reader );
                
        }

        private System.IO.Stream GetEmbeddedFile( string assemblyName, string filename )
        {
            System.Reflection.Assembly assembly = System.Reflection.Assembly.Load( assemblyName );
            System.IO.Stream stream = assembly.GetManifestResourceStream( string.Format( "{0}.{1}", assemblyName, filename ) );

            if ( stream == null )
                throw new Exception( "Could not locate the embedded resource." );

            return stream;
        }

        private System.IO.Stream GetEmbeddedFile( System.Reflection.Assembly assembly, string filename )
        {
            string assemblyName = assembly.GetName().Name;
            return GetEmbeddedFile( assemblyName, filename );
        }

        public System.Xml.XmlTextReader GetEmbeddedXml( Type type, string filename )
        {
            System.IO.Stream stream = GetEmbeddedFile( type.Assembly.GetName().Name, filename );
            System.Xml.XmlTextReader xmlReader = new System.Xml.XmlTextReader( stream );

            return xmlReader;
        }

        private void MenuItemOnClick_Open( object sender, EventArgs e )
        {
            MessageBox.Show( "Open Clicked" );
        }

        private void MenuItemOnClick_Close( object sender, EventArgs e )
        {
            MessageBox.Show( "Close Clicked" );
        }

        private void MenuItemOnClick_Exit( object sender, EventArgs e )
        {
            Application.Exit();
        }
    }
}