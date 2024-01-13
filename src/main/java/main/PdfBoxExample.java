package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfBoxExample {

	public static void main(String[] args) {
		
		// 処理前の時刻を取得
		long startTime = System.currentTimeMillis();
		System.out.println("開始時刻：" + startTime + " ms");
		
		File file = new File("C:\\pleiades\\2022-06\\workspace\\PdfAnalyze\\src\\main\\java\\main\\test.pdf");
		
		PDDocument document = null;
		
		try {
			document = PDDocument.load(file);
			// 文字列のみ抽出
			PDFTextStripper pdfTextStripper = new PDFTextStripper();

			// 左上から右下の順番で文字列を読み取る設定
			// pdfStripper.setSortByPosition(true);
			// pdfからテキスト抽出（デバッグ用）
			// System.out.println(pdfStripper.getText(pdDoc));
			
			String pdfText = pdfTextStripper.getText(document);
			
			String[] splitText = pdfText.split("\n");
			
			List<String> suggestText = new ArrayList<String>();
			
			// サジェスト用に特定文字を含む値を抽出
			for (String txt : splitText) {
				if (txt.contains("円") || txt.contains("¥")) {
					suggestText.add(txt);
				}
			}
			
			System.out.println(suggestText);
			
			// 処理後の時刻を取得
			long endTime = System.currentTimeMillis();
			System.out.println("開始時刻：" + endTime + " ms");
			
			System.out.println("処理時間：" + (endTime - startTime) + " ms");
			
			document.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
