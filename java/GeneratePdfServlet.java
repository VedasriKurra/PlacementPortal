//import java.awt.Graphics2D;
//import java.awt.PageFormat;
//import java.awt.print.PageFormat;
//import java.awt.print.PrinterException;
//import java.awt.print.PrinterJob;
//import java.awt.print.Printer;
//
//public class PrintToPDF {
//    public static void main(String[] args) {
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintable(new Printable() {
//            @Override
//            public int print(Graphics g, PageFormat format, int pageIndex) throws PrinterException {
//                if (pageIndex > 0) {
//                    return NO_SUCH_PAGE;
//                }
//
//                Graphics2D g2d = (Graphics2D) g;
//                g2d.translate(format.getImageableX(), format.getImageableY());
//
//                // Set up font, color, and print the document content
//                g2d.setFont(new Font("Serif", Font.PLAIN, 12));
//                g2d.drawString("Batch Details:", 100, 100);
//                g2d.drawString("Batch: 593", 100, 120);
//
//                return PAGE_EXISTS;
//            }
//        });
//
//        try {
//            // Configure Print Service to print to a PDF file
//            PrintService pdfPrinter = PrintServiceLookup.lookupDefaultPrintService(null, null);
//            DocPrintJob job = pdfPrinter.createPrintJob();
//            job.print(new SimpleDoc(new PrintDataSource(), DocFlavor.SERVICE_FORMATTED.PRINTABLE, null), null);
//        } catch (PrintException e) {
//            e.printStackTrace();
//        }
//    }
//}
