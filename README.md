# System-Design-Docker

授業『システム設計』環境構築のためのレポジトリ

## Windowsユーザ向け環境構築方法
以下のすべての手順を実行してください．

### STEP-1 WSL,VSCodeのインストール

手順1 windowsボタンを右クリックして，ターミナル(またはpower shell)を管理者権限で起動
![ターミナルの起動](./imgs/terminal.png "terminal")

手順2 以下のコマンドを1行づつコピーして実行
```
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
iwr -useb https://raw.githubusercontent.com/HazeyamaLab/system-design-docker/master/script/install.ps1 | iex
```

手順3 Ubuntu というCLIが立ち上がり，ユーザ名とパスワードの設定が求められるので設定．このとき __パスワードは入力しても画面上に表示されないので要注意！__
![ubuntuの初期設定](https://qiita-user-contents.imgix.net/https%3A%2F%2Fqiita-image-store.s3.ap-northeast-1.amazonaws.com%2F0%2F501257%2Fc10290ae-bd55-1ab1-4bbe-c885d205c45b.jpeg?ixlib=rb-4.0.0&auto=format&gif-q=60&q=75&w=1400&fit=max&s=28007229fb9c514b94e047923efacbfb "terminal")

以上でSTEP-1完了．

### STEP-2 Docker-Desktopのインストール
  
手順1 Docker Desktopのダウンロード・インストール
  
https://www.docker.com/products/docker-desktop/ にアクセス，ダウンロード．
![docker](./imgs/docker.png "terminal")  
チェックボックスはどちらもチェックが入っていることを確認． 
![docker-install](./imgs/check.png "terminal")  
規約に同意したらAcceptボタンでインストール．
![term](./imgs/term.png "terminal")  
チュートリアルをスキップすると，このようなメイン画面が出現．
![term](./imgs/docker-main.png "terminal")  
  
手順2 Dockerの設定  
WSL上でDockerが動作するように設定する．
Docker-Desktopのメイン画面左上の矢印マークを押して設定画面を開き，右側のResourcesタブからWSL integrationを選択し，Ubuntuのチェックを入れてRefreshを押下．
![term](./imgs/docker-config.png "terminal")  

以上でSTEP-2は完了．

### STEP-3 Ubuntu上での環境整備  
  手順1
Ubuntuを起動し，CLIが立ち上がるのを確認する．
![ubuntu](./imgs/ubuntu.png "terminal")  
  
手順2
Ubuntu CLIで以下のコマンドを実行．
```
curl -sf https://raw.githubusercontent.com/HazeyamaLab/system-design-docker/master/script/setup.sh | sh -s
```
パスワードが求められるので．STEP-1 手順3で入力したパスワードを入力．
  
手順3
VSCodeが立ち上がるので，左のテトリスのようなアイコンを選択し，Dev Containerの拡張機能を検索欄から検索してインストール．
![ubuntu](./imgs/dev-con.png "terminal")  
  
手順4
右下に以下のようなWindowが出現するので，Reopen in Containerを選択 __このとき8080，8081，3307のポートが使われていると正常に起動しない，特にローカルにMySQLがインストールされている場合は要注意__
![ubuntu](./imgs/reopen.png "terminal")  
  
手順5  
初回起動時は特に時間がかかるのでしばらく待機．その後，画面下部ターミナルで以下のコマンドを実行．もしターミナルが表示されていなければ，上部メニューバーの ターミナル -> 新しいターミナル で出現する．
```
./gradlew tR
```
![ubuntu](./imgs/vscode-terminal.png "terminal")  
  
手順6  
```
> Task :tomcatRun
Started Tomcat Server
The Server is running at http://localhost:8080/system-design-dev
```
以上の出力を確認した後，
http://localhost:8080/system-design-dev にアクセスし下の画面が出現すれば環境構築は終了．
お疲れ様でした．
![ubuntu](./imgs/hello.png "terminal")