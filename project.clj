(defproject ngtouch "0.1.0"
  :description "ngTouch"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [xnlogic/clobber "0.1.0-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "0.3.2"]]
  :cljsbuild {
    :builds {
      :dev {
        :source-paths ["app/cljs-lib" "app/scripts"]
        :compiler {
          :output-to ".tmp/scripts/ngtouch.js"
          :optimizations :whitespace
          :pretty-print true
        }
      }
      :prod {
        :source-paths ["app/cljs-lib" "app/scripts"]
        :compiler {
          :externs ["externs/angular.js" "externs/bacon.js"]
          :output-to ".tmp/scripts/ngtouch.js"
          :pretty-print false
          :optimizations :advanced
        }
      }
      :pre-prod {
        :source-paths ["app/cljs-lib" "app/scripts"]
        :compiler {
          :output-to ".tmp/scripts/ngtouch.js"
          :optimizations :simple
          :pretty-print false
        }
      }
    }
  })


