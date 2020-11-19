namespace MainMenuTestApp
{
    partial class MenuStripEnhancedForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose( bool disposing )
        {
            if ( disposing && ( components != null ) )
            {
                components.Dispose();
            }
            base.Dispose( disposing );
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStripEnhanced1 = new MainMenuEnhanced.MenuStripEnhanced();
            this.SuspendLayout();
            // 
            // menuStripEnhanced1
            // 
            this.menuStripEnhanced1.Location = new System.Drawing.Point(0, 0);
            this.menuStripEnhanced1.Name = "menuStripEnhanced1";
            this.menuStripEnhanced1.Size = new System.Drawing.Size(666, 24);
            this.menuStripEnhanced1.TabIndex = 0;
            this.menuStripEnhanced1.XmlPath = "MenuAdministrator.xml";
            // 
            // MenuStripEnhancedForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(666, 160);
            this.Controls.Add(this.menuStripEnhanced1);
            this.MainMenuStrip = this.menuStripEnhanced1;
            this.Name = "MenuStripEnhancedForm";
            this.Text = "Enhanced Menu Strip";
            this.Load += new System.EventHandler(this.MenuStripEnhanced_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private MainMenuEnhanced.MenuStripEnhanced menuStripEnhanced1;
    }
}