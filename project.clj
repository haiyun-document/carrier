(defproject carrier "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [cheshire "4.0.3"]
                 [compojure "1.1.3"]
                 [clojure-mail "0.1.1-SNAPSHOT"]]
                 
  :ring {:handler carrier.web/app}
  :plugins [[lein-ring "0.7.5"]])
