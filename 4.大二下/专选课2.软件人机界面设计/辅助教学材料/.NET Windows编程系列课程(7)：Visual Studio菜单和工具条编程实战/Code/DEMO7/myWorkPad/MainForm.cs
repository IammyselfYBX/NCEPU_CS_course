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
        private int checkPrint;
        string strFileName = "";
        public MainForm()
        {
            InitializeComponent();
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

        private void 打开OToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void 另存为AToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {
            PageSetupDialog pageSetupDialog = new PageSetupDialog();
            pageSetupDialog.Document = printDocument;
            pageSetupDialog.ShowDialog();

        }

        private void 打印PToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void 打印预览VToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void 退出XToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void 撤消UToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Undo();
        }

        private void 重复RToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Redo();
        }

        private void 剪切TToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Cut();
        }

        private void 复制CToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Copy();
        }

        private void 粘贴PToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Paste();
        }

        private void 全选AToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectAll();
        }

        private void 清除ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.Clear();
        }

        private void 字体FToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void 颜色CToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void 左对齐LToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectionAlignment = HorizontalAlignment.Left;

        }

        private void 居中EToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectionAlignment = HorizontalAlignment.Center;
        }

        private void 右对齐RToolStripMenuItem_Click(object sender, EventArgs e)
        {
            rtMain.SelectionAlignment = HorizontalAlignment.Right;
        }

        private void 关于AToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AboutDialog dlg = new AboutDialog();
            dlg.ShowDialog();
        }

        private void 保存SToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (strFileName != "")
                rtMain.SaveFile(strFileName);
            else
                另存为AToolStripMenuItem_Click(sender, e);

        }

        private void 新建NToolStripMenuItem_Click(object sender, EventArgs e)
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

        private void tsbBold_Click(object sender, EventArgs e)
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

        private void ttsbItalic_Click(object sender, EventArgs e)
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

        private void ttsbUnderLine_Click(object sender, EventArgs e)
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

        private void MainForm_Load(object sender, EventArgs e)
        {
            //初始化字体选择
            foreach (FontFamily oneFontFamily in FontFamily.Families)
            {
                tscbFont.Items.Add(oneFontFamily.Name);
            }
            tscbFont.SelectedItem = "宋体";
            tscbSize.SelectedIndex = 2;
        }

        private void tscbFont_SelectedIndexChanged(object sender, EventArgs e)
        {
           if (tscbSize.SelectedItem == null)
                return;
           FontFamily family = new FontFamily(tscbFont.SelectedItem.ToString());
           float emSize = float.Parse(tscbSize.SelectedItem.ToString());
           System.Drawing.Font newFont = new Font(family,emSize);;
           rtMain.SelectionFont = newFont;
           rtMain.Focus();          
        }

        private void menuMain_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void 剪切TToolStripMenuItem_Click_1(object sender, EventArgs e)
        {

        }
       
    }
}