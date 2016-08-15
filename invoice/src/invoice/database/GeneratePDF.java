package invoice.database;

import invoice.beans.Client;
import invoice.beans.Project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF{
	private BaseFont font,font1;
	private int displayPageNumber = 0;
	public GeneratePDF(String filename,Client client,Project project,ArrayList workedDevelopers,String amount,String invoiceNumber){
		generateClinetInvoicePDF(filename+".pdf",client,project,workedDevelopers,amount,invoiceNumber);
	}
	private void generateClinetInvoicePDF(String filename,Client client,Project project,ArrayList workedDevelopers,String amount,String invoiceNumber){
		 Document document = new Document();
		 PdfWriter documentPdfWriter = null;
		 initializeTextSizeFonts();
		 try {
			 String path = "C://Users//harsha//Desktop//clientinvoices//"+filename;
			 documentPdfWriter = PdfWriter.getInstance(document , new FileOutputStream(path));
			 document.addAuthor("OCU");
			 document.addCreationDate();
			 document.addProducer();
			 document.addCreator("Harsha");
			 document.addTitle("Invoice PDF format");
			 document.setPageSize(PageSize.LETTER);
			 document.open();
			 PdfContentByte pdfcontentByte = documentPdfWriter.getDirectContent();	   
			 boolean beginPageNo = true;
			 writedata(pdfcontentByte,402,762,"Eagle Consulting Invoice");
			 int height=0;
			 for(int width=0;width<workedDevelopers.size();width++){
				 String[] developinvoicedata=(String[])workedDevelopers.get(width);
				 if(beginPageNo){
					 beginPageNo = false;
					 clientinvoicedetails(document,pdfcontentByte,invoiceNumber); 
					 pdfheaader(pdfcontentByte,client,amount,project);
					 height=505; 
				 }
				 developersdata(pdfcontentByte,width,height,developinvoicedata);
				 height=height-16;
				 if(height<50){
					 displaypageNumber(pdfcontentByte);
					 document.newPage();
					 beginPageNo = true;
				 }
			 }
			 writedata(pdfcontentByte,50,150,"Remit Payment To:");
			 writedata(pdfcontentByte,75,135,"Eagle Consulting");
			 writedata(pdfcontentByte,75,120,"2501 E Memorial Road");
			 writedata(pdfcontentByte,75,105,"Edmond, Ok 73013");			 
			 displaypageNumber(pdfcontentByte);
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }finally{
			 if(document != null){
				 document.close();
			 }
			 if(documentPdfWriter != null){
				 documentPdfWriter.close();
			 }
		 }
	 }
	 private void clientinvoicedetails(Document document,PdfContentByte pdfcontecntbyte,String invoicenumber){
		 try{
			 pdfcontecntbyte.setLineWidth(1f);
			 pdfcontecntbyte.rectangle(40,616,511,121);
			 pdfcontecntbyte.moveTo(275,735);
			 pdfcontecntbyte.lineTo(275,615);
			 pdfcontecntbyte.stroke();
			 writedata(pdfcontecntbyte,376,723,"Invoice Number: "+invoicenumber);
			 writedata(pdfcontecntbyte,376,703,"Invoice Date: "+new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
			 writedata(pdfcontecntbyte,376,683,"Payment Terms: ");
			 writedata(pdfcontecntbyte,376,663,"Billing Frequency: ");
			 writedata(pdfcontecntbyte,376,643,"Total Amount Due: $");
			 pdfcontecntbyte.rectangle(20,50,550,410); 
			 writedata(pdfcontecntbyte,50,524,"Date");
			 writedata(pdfcontecntbyte,150,524,"Description");
			 writedata(pdfcontecntbyte,400,524,"Rate");
			 writedata(pdfcontecntbyte,450,524,"Hours");
			 writedata(pdfcontecntbyte,500,524,"Amount");
			 Image companyLogo = Image.getInstance(System.getProperty("user.dir")+"/src/invoice/main/logo.png");
			 companyLogo.setAbsolutePosition(51,751);
			 companyLogo.scalePercent(25);
			 document.add(companyLogo);
		 }catch (Exception dex){
			 dex.printStackTrace();
		 }
	 }
	 
	 private void pdfheaader(PdfContentByte pdfcontentbyte,Client client,String totalamount,Project project){
		 try{
			 writedata(pdfcontentbyte,76,723,client.getName());
			 writedata(pdfcontentbyte,76,708,client.getAddressline1());
			 writedata(pdfcontentbyte,76,693,client.getAddressline2());
			 writedata(pdfcontentbyte,76,678,client.getCity()+","+client.getState()+" - "+client.getZip());
			 writedata(pdfcontentbyte,76,663,"United States");
			 writedata(pdfcontentbyte,76,648,"Client ID#: "+client.getNumber());
			 writedata(pdfcontentbyte,76,633,project.getProjectName());			 
			 writedata(pdfcontentbyte,476,683,client.getBillingTerms());
			 writedata(pdfcontentbyte,476,663,client.getInvoiceFreq());
			 writedata(pdfcontentbyte,476,643,totalamount);
		 }catch (Exception ex){
			 ex.printStackTrace();
		 }
	 }
	 
	 private void developersdata(PdfContentByte pdfcontentbyte,int index,int height,String[] developinvoicedata){
		 try{
			 createContent(pdfcontentbyte,111,height,developinvoicedata[4]+" - "+developinvoicedata[5],PdfContentByte.ALIGN_RIGHT);
			 createContent(pdfcontentbyte,151,height,developinvoicedata[2],PdfContentByte.ALIGN_LEFT);
			 createContent(pdfcontentbyte,401,height,developinvoicedata[6],PdfContentByte.ALIGN_LEFT);
			 createContent(pdfcontentbyte,466,height,developinvoicedata[3],PdfContentByte.ALIGN_RIGHT);
			 createContent(pdfcontentbyte,522,height,""+((Integer.parseInt(developinvoicedata[6])*(Integer.parseInt(developinvoicedata[3])))),PdfContentByte.ALIGN_RIGHT);
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	 }

	 private void writedata(PdfContentByte pdfcontentbyte,float width,float height,String textmessage){
		 pdfcontentbyte.beginText();
		 pdfcontentbyte.setFontAndSize(font, 10);
		 pdfcontentbyte.setTextMatrix(width,height);
		 pdfcontentbyte.showText(textmessage.trim());
		 pdfcontentbyte.endText();
	 }
	 
	 private void displaypageNumber(PdfContentByte pdfcontentbyte){
		 pdfcontentbyte.beginText();
		 pdfcontentbyte.setFontAndSize(font,10);
		 pdfcontentbyte.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. "+(displayPageNumber+1),572,26,0);
		 pdfcontentbyte.endText();
		 displayPageNumber++;	  
	 }
	 
	 private void createContent(PdfContentByte pdfcontentbyte,float width,float height,String textmessage,int alignment){
		 pdfcontentbyte.beginText();
		 pdfcontentbyte.setFontAndSize(font1, 8);
		 pdfcontentbyte.showTextAligned(alignment,textmessage.trim(),width,height,0);
		 pdfcontentbyte.endText(); 
	 }

	 private void initializeTextSizeFonts(){
		 try{
			 font=BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			 font1=BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }	
}
