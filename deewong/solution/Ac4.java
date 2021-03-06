package deewong.solution;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ac4 {

    public static void main(String[] args) {

        // User input
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Cache Size
        int m = sc.nextInt(); // Page Request Times

        PageManager pageManager = new Ac4().new PageManager(n);

        for (int i = 0; i < m; i++) {
            pageManager.pageIn(sc.nextInt());
        }

        sc.close();

        pageManager.getAnswer();

    }

    public class PageManager {

        private int output = 0;
        private int cacheMaxSize;
        private int count;
        private LinkedHashSet<Integer> pages;

        public PageManager(int cacheMaxSize) {
            this.cacheMaxSize = cacheMaxSize;
            this.pages = new LinkedHashSet<>();
            this.count = pages.size();
        }

        public boolean isFull() {
            return this.count == this.cacheMaxSize;
        }

        public void pageIn(int pageNum) {

            if (!pages.contains(pageNum)) {
                // pages do not include specifc pageNum
                if (this.isFull()) {
                    // remove first one
                    // will add one soon and don't change the count
                    this.pages.remove(this.pages.iterator().next());
                }
                pages.add(pageNum);
                this.output ++;
                this.count ++;
                
            } else {
                // nothing to do because pages contains pageNum
            }
        }

        public void getAnswer() {
            System.out.println(this.output);
        }

    }
}