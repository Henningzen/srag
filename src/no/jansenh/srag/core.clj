;; -----------------------------------------------------------------------------
;; File: src/no/jansenh/srag/core.clj
;; Author: Henning Jansen - henning.jansen@jansenh.no
;; Copyright: (c) 2025
;; License: Distributed under the GNU General Public License v3.0
;; as described in the root of this project.
;; -----------------------------------------------------------------------------

(ns no.jansenh.srag.core
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [tablecloth.api :as tc]) 
  (:import
   [dev.langchain4j.store.embedding.inmemory InMemoryEmbeddingStore]
   [dev.langchain4j.data.segment TextSegment]
   [dev.langchain4j.data.document.parser.apache.pdfbox ApachePdfBoxDocumentParser]
   [dev.langchain4j.data.document.splitter DocumentSplitters]
   [dev.langchain4j.model.embedding.onnx.allminilml6v2 AllMiniLmL6V2EmbeddingModel]))

;; Simple RAG - Retrieval Augmented Generation - core namespace
;;
;;   Create embedding from clean texts:
;;     This is where it all starts. We'll invoke an in-memory embedding-store
;;     and the embedding model sentence transformer.
;;
;;
;; authors:   Henning Jansen            henning.jansen@jansenh.no
;; since:     0.1.0                     2025-05-05
;; version:   0.1.0
;; -----------------------------------------------------------------------------

;;
;; Convert text into arrays of numbers
(def embedding-model (AllMiniLmL6V2EmbeddingModel.))

;; Store and retrieve arrays of number
(def embedding-store (InMemoryEmbeddingStore.))

