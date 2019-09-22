package reactive.reactx;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> symbols){
        System.out.println("created.....");
        Observable.create(emitter -> emitPrice(emitter));
        return null;
    }

    private static void emitPrice(ObservableEmitter<Object> emitter) {
        System.out.println("ready to emit......");
    }
}
