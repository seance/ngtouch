(ns ngtouch.controllers
  (:require-macros [clang.angular :refer [def.controller]])
  (:require ngtouch
            [jayq.core :as $]
            [yolk.bacon :as b])
  (:use [jayq.core :only [$]]))

(defmacro def.scope [n value]
  `(assoc! ~'$scope ~(name n) ~@value))

(def.controller ngtouch/App MainCtrl [$scope]
  (def.scope :awesomeThings ["AngularJS"])
  #_(assoc! $scope :awesomeThings ["AngularJS" "ClojureScript" "Bacon"])

  (def label1 ($ :#label1))

  (-> ($ :#label1)
      ($/html "Hello!"))

  (defn assign-input-value [x]
    (.log js/console (str "Assign " x))
    (assoc! $scope :inputValue x)
    (.$apply $scope))

  (-> ($ :#input1)
      (.asEventStream "input")
      (b/map #(-> % .-target .-value))
      (b/skip-duplicates)
      (b/to-property "")
      (b/filter #(not= "" %))
      #_(b/on-value #(.log js/console %))
      #_(.assign label1 "text")
      (b/on-value assign-input-value)))
