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
    public partial class ChildForm : Form
    {
        private int checkPrint;
        string strFileName = "";
        public ChildForm()
        {
            InitializeComponent();
        }
        public ZYBRichTextBox m_rtMain
        {
            get { return rtMain; }
         }	

        private void printDocument_PrintPage(object sender, System.Drawing.Printing.PrintPageEventArgs e)
        {
            checkPrint = rtMain.Print(checkPrint, rtMain.TextLength, e);

            // Check for more pages
            if (checkPrint < rtMain.TextLength)
                e.HasMorePages = true;
            else
                e.HasMorePages = false;
        }

        private void printDocument_BeginPrint(object sender, System.Drawing.Printing.PrintEventArgs e)
        {
            checkPrint = 0;
        }

        private void printDocument_EndPrint(object sender, System.Drawing.Printing.PrintEventArgs e)
        {
            MessageBox.Show(printDocument.DocumentName + " 已经打印完成！");
        }

        public  void 打开OToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.InitialDirectory = "c:\\";//注意这里写路径时要用c:\\而不是c:\
            openFileDialog.Filter = "文本文件|*.txt|RTF文件|*.rtf|所有文件|*.*";
            openFileDialog.RestoreDirectory = true;
            openFileDialog.FilterIndex = 2;
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    string fName = openFileDialog.FileName;
                    rtMain.LoadFile(fName);
                    printDocument.DocumentName = Path.GetFileName(fName);
                    strFileName = fName;
                    this.Text = Path.GetFileNameWithoutExtension(fName) +"--写字板";  
                }
                catch (System.IO.FileNotFoundException)
                {
                    MessageBox.Show("没有找到文件！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }

            }
            rtMain.Focus();
        }

        public void 另存为AToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();
            saveFileDialog.Filter = "文本文件|*.txt|RTF文件|*.rtf|所有文件|*.*";
            saveFileDialog.FilterIndex = 2;
            saveFileDialog.RestoreDirectory = true;
            if (saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    string strName = saveFileDialog.FileName;
                    switch (Path.GetExtension(strName).ToLower())
                    {
                        case ".txt":
                            rtMain.SaveFile(strName, RichTextBoxStreamType.PlainText);
                            break;
                        case ".rtf":
                            rtMain.SaveFile(strName, RichTextBoxStreamType.RichText);
                            break;
                        default:
                            rtMain.SaveFile(strName);
                            break;
                    }
                }
                catch (System.Exception err)
                {
                    MessageBox.Show(err.Message);
                }
            }
            rtMain.Focus();
        }

        public void toolStripMenuItem1_Click(object sender, EventArgs e)
        {
            PageSetupDialog pageSetupDialog = new PageSetupDialog();
            pageSetupDialog.Document = printDocument;
            pageSetupDialog.ShowDialog();

        }

        public void 打印PToolStripMenuItem_Click(object sender, EventArgs e)
        {
            PrintDialog printDialog = new PrintDialog();
            printDialog.Document = printDocument;
            if (printDialog.ShowDialog() != DialogResult.Cancel)
            {
                try
                {
                    printDocument.Print();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }
        }

        public void 打印预览VToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StringReader lineReader = new StringReader(rtMain.Text);
            try
            {
                PrintPreviewDialog printPreviewDialog = new PrintPreviewDialog();
                printPreviewDialog.Document = printDocument;
                printPreviewDialog.FormBorderStyle = FormBorderStyle.Fixed3D;
                printPreviewDialog.ShowDialog();
            }
            catch (Exception excep)
            {
                MessageBox.Show(excep.Message, "打印出错", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
        }

        public void 撤消UToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Undo();
        }

        public void 重复RToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Redo();
        }

        public void 剪切TToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Cut();
        }

        public void 复制CToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Copy();
        }

        public void 粘贴PToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Paste();
        }

        public void 全选AToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectAll();
        }

        public void 清除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Clear();
        }

        public void 字体FToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FontDialog fontDialog = new FontDialog();
            fontDialog.Color = rtMain.ForeColor;
            fontDialog.AllowScriptChange = true;
            //fontDialog.ShowColor = true;
            if (fontDialog.ShowDialog() != DialogResult.Cancel)
            {
                rtMain.SelectionFont = fontDialog.Font;//将当前选定的文字改变字体
                // rtMain.SelectionColor = fontDialog.Color;
            }
            rtMain.Focus();

        }

        public void 颜色CToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ColorDialog colorDialog = new ColorDialog();
            colorDialog.AllowFullOpen = true;
            colorDialog.FullOpen = true;
            colorDialog.ShowHelp = true;
            colorDialog.Color = Color.Black;//初始化当前文本框中的字体颜色，当用户在ColorDialog对话框中点击"取消"按钮恢复原来的值
            if (colorDialog.ShowDialog() != DialogResult.Cancel)
            {
                rtMain.SelectionColor = colorDialog.Color; //将当前选定的文字改变颜色
            }
            rtMain.Focus();

        }

        private void 图像PToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            // openFileDialog.InitialDirectory = "c:\\";//注意这里写路径时要用c:\\而不是c:\
            openFileDialog.Filter = "位图文件|*.bmp|gif文件|*.gif|TIFF文件|*.tif|jpg文件|*.jpg|所有文件|*.*";
            openFileDialog.RestoreDirectory = true;
            openFileDialog.FilterIndex = 1;
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    string fName = openFileDialog.FileName;
                    Bitmap img = new Bitmap(fName);
                    rtMain.InsertImage(img);

                }
                catch (System.IO.FileNotFoundException)
                {
                    MessageBox.Show("没有找到文件！", "错误", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }

            }
            rtMain.Focus();

        }

        public void 左对齐LToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectionAlignment = HorizontalAlignment.Left;

        }

        public void 居中EToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectionAlignment = HorizontalAlignment.Center;
        }

        public void 右对齐RToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectionAlignment = HorizontalAlignment.Right;
        }

        public void 保存SToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (strFileName != "")
                rtMain.SaveFile(strFileName);
            else
                另存为AToolStripMenuItem_Click(sender, e);

        }

        public void 新建NToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("要保存现有文件吗", "提示对话框", MessageBoxButtons.YesNo, MessageBoxIcon.Question)
                == DialogResult.Yes)
                保存SToolStripMenuItem_Click(sender, e);
            else
            {
                strFileName = "";
                rtMain.Clear();
            }
            this.Text = "新建文档 --写字板";  
        }
        public void tsbBold_Click(object sender, EventArgs e)
        {
            //处理粗体显示
            System.Drawing.Font oldFont = rtMain.SelectionFont;
            System.Drawing.Font newFont;
            if (oldFont.Bold)
                newFont = new Font(oldFont, oldFont.Style & ~FontStyle.Bold);
            else
                newFont = new Font(oldFont, oldFont.Style | FontStyle.Bold);

            rtMain.SelectionFont = newFont;
            rtMain.Focus();

        }

        public void ttsbItalic_Click(object sender, EventArgs e)
        {
            //处理斜体显示
            System.Drawing.Font oldFont = rtMain.SelectionFont;
            System.Drawing.Font newFont;
            if (oldFont.Italic)
                newFont = new Font(oldFont, oldFont.Style & ~FontStyle.Italic);
            else
                newFont = new Font(oldFont, oldFont.Style | FontStyle.Italic);
            rtMain.SelectionFont = newFont;
            rtMain.Focus();

        }

        public void ttsbUnderLine_Click(object sender, EventArgs e)
        {
            //处理下划线显示
            System.Drawing.Font oldFont = rtMain.SelectionFont; ;
			System.Drawing.Font newFont;
			if(oldFont.Underline)
				newFont = new Font(oldFont,oldFont.Style&~FontStyle.Underline);
			else
				newFont = new Font(oldFont,oldFont.Style|FontStyle.Underline);
			  rtMain.SelectionFont = newFont;
            rtMain.Focus();

        }
        private void MainForm_Load(object sender, EventArgs e)
        {
            MainForm parent = (MainForm)this.MdiParent;

            //初始化字体选择
            foreach (FontFamily oneFontFamily in FontFamily.Families)
            {
                parent.m_tscbFont.Items.Add(oneFontFamily.Name);
            }
            parent.m_tscbFont.SelectedItem = "宋体";
            parent.m_tscbSize.SelectedIndex = 2;
        }

        private void tscbFont_SelectedIndexChanged(object sender, EventArgs e)
        {
           MainForm parent = (MainForm)this.MdiParent;
           if (parent.m_tscbSize.SelectedItem == null)
                return;
           FontFamily family = new FontFamily(parent.m_tscbFont.SelectedItem.ToString());
           float emSize = float.Parse(parent.m_tscbSize.SelectedItem.ToString());
           System.Drawing.Font newFont = new Font(family,emSize);;
           rtMain.SelectionFont = newFont;
           rtMain.Focus();          
        }

        private void ChildForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            if (MessageBox.Show("要保存现有文件吗", "提示对话框", MessageBoxButtons.YesNo, MessageBoxIcon.Question)
                 == DialogResult.Yes)
                保存SToolStripMenuItem_Click(sender, e);
        }
       
    }
}