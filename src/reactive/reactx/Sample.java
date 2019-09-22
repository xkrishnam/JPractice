package reactive.reactx;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<String> symbols= Arrays.asList("GOOG","AMZN","ITC");
        Observable<StockInfo> feed = StockServer.getFeed(symbols);
        System.out.println("got observable.....");
        feed.subscribe(si -> System.out.println(si));
    }
}
