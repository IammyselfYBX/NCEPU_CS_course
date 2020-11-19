using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace myWorkPad
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }
        public ToolStripComboBox m_tscbFont
        {
            get { return tscbFont; }
        }
        public ToolStripComboBox m_tscbSize
        {
            get { return tscbSize; }
        }	
        private void 退出XToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
      
        private void 关于AToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AboutDialog dlg = new AboutDialog();
            dlg.ShowDialog();
        }      

        private void 自定义CToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem ts = (ToolStripMenuItem)sender;
            ts.Checked = !(ts.Checked);
            toolMain.Visible = ts.Checked;
        }

        private void 选项OToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem ts = (ToolStripMenuItem)sender;
            ts.Checked = !(ts.Checked);
            statusMain.Visible = ts.Checked;
        }
    
        private void 格式栏FToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem ts = (ToolStripMenuItem)sender;
            ts.Checked = !(ts.Checked);
            toolFormat.Visible = ts.Checked;
        }
     
        private void tsbBold_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "将选定内容变为粗体";
        }

        private void tsbBold_MouseLeave(object sender, EventArgs e)
        {
            statusLabel.Text = "简易写字板";
        }

        private void ttsbItalic_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "将选定内容变为斜体";
        }

        private void ttsbUnderLine_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "用连续下划线格式化选定内容";
        }

        private void 新建NToolStripButton_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "创建新文档";
        }

        private void 打开OToolStripButton_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "打开已存文档";
        }

        private void 保存SToolStripButton_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "保存当前文档";
        }

        private void 打印PToolStripButton_MouseEnter(object sender, EventArgs e)
        {
            statusLabel.Text = "打印当前文档";
        }

        private void tscbFont_SelectedIndexChanged(object sender, EventArgs e)
        {
           if (tscbSize.SelectedItem == null)
                return;
           FontFamily family = new FontFamily(tscbFont.SelectedItem.ToString());
           float emSize = float.Parse(tscbSize.SelectedItem.ToString());
           System.Drawing.Font newFont = new Font(family,emSize);
           ChildForm child = (ChildForm)this.ActiveMdiChild;
           if (child != null)
           {
               child.m_rtMain.SelectionFont = newFont;
               child.m_rtMain.Focus();
           }
        }

        private void 新建窗口NToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ChildForm cForm = new ChildForm();
            cForm.MdiParent = this;
            cForm.Show();

        }

        private void 排列ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.ArrangeIcons);

        }

        private void 水平平铺HToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.TileHorizontal);

        }

        private void 垂直平铺VToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.TileVertical);

        }

        private void 层叠CToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(System.Windows.Forms.MdiLayout.Cascade);

        }

        private void 新建NToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.新建NToolStripMenuItem_Click(sender, e);
            }
        }

        private void 打开OToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.打开OToolStripMenuItem_Click(sender, e);
            }
        }

        private void 保存SToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.保存SToolStripMenuItem_Click(sender, e);
            }
        }

        private void 打印PToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.打印PToolStripMenuItem_Click(sender, e);
            }
        }

        private void 剪切UToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.剪切TToolStripMenuItem_Click(sender, e);
            }
        }

        private void 复制CToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.复制CToolStripMenuItem_Click(sender, e);
            }
        }

        private void 粘贴PToolStripButton_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.粘贴PToolStripMenuItem_Click(sender, e);
            }
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.左对齐LToolStripMenuItem_Click(sender, e);
            }
        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.居中EToolStripMenuItem_Click(sender, e);
            }
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.右对齐RToolStripMenuItem_Click(sender, e);
            }
        }

        private void ttsbItalic_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.ttsbItalic_Click(sender, e);
            }
        }

        private void tsbBold_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.tsbBold_Click(sender, e);
            }
        }

        private void ttsbUnderLine_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.ttsbUnderLine_Click(sender, e);
            }
        }

        private void toolStripButton7_Click(object sender, EventArgs e)
        {
            ChildForm child = (ChildForm)this.ActiveMdiChild;
            if (child != null)
            {
                child.字体FToolStripMenuItem_Click(sender, e);
            }
        }
       
    }
}