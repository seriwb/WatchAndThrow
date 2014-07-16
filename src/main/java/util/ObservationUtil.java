package util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

/**
 * 監視系Util
 *
 * @author seri
 */
public class ObservationUtil {

  /**
   * 指定されたフォルダを監視する
   *
   * @param path 監視先のフォルダのパス
   * @throws IOException 存在しないフォルダを指定した場合
   * @throws InterruptedException 待機中に割り込みが発生した場合
   */
  public static void watchNewFile(String path, String trashPath)
      throws IOException, InterruptedException {

    // 監視場所を指定
    Path dir = Paths.get(path);
    WatchService watcher = FileSystems.getDefault().newWatchService();

    // 新しいファイルが作成されるのを監視する（ドロップ待ち）
    dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

    List<Path> pathList = new ArrayList<>();

    // Path child = null;
    while (true) {
      // 監視キー：監視可能なオブジェクトが監視サービスに登録されると作成される。
      // ここでは新しいファイルが作成されるとキーができる。
      WatchKey watchKey = watcher.take();

      for (WatchEvent<?> event : watchKey.pollEvents()) {

        // 何のイベントかをチェック
        WatchEvent.Kind<?> kind = event.kind();
        // イベントが失われたか破棄された可能性があることを示す特殊イベントの場合
        if (kind == StandardWatchEventKinds.OVERFLOW) {
          continue;
        }

        // 変更のあったパスを取得
        Path name = (Path) event.context();
        pathList.add(dir.resolve(name));

        // System.out.println(child + "が作成されました。");

      }

      // TODO:リスト分のファイル転送、転送時の日時をファイル名に付与する
      // TODO:送信ファイルはゴミに移動（メソッド名変更）
      // TODO:クリアしたリストには現在存在するファイルのPathを設定する

      // ----------後処理--------
      // リセットしないと繰り返されない
      watchKey.reset();
      // pathList.clear();
    }
  }
}
