(ns ngtouch
  (:require-macros [clang.angular :refer [def.config]])
  (:use [clang.util :only [module]]))

(def App (module "ngtouchApp" ["clang"
                               "ngRoute"
                               "ngCookies"
                               "ngResource"
                               "ngSanitize"]))

(def.config App [$routeProvider]
  (doto $routeProvider
    (.when "/"
           (clj->js {:templateUrl "views/main.html"
                     :controller "MainCtrl"}))
    (.otherwise
           (clj->js {:redirectTo "/"}))))
