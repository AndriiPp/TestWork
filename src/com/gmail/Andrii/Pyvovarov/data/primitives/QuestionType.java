package com.gmail.Andrii.Pyvovarov.data.primitives;

import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;

import java.util.Objects;

public class QuestionType {
    private String questionType;
    private CategoryQuestionType category;

    public QuestionType(String questionType) {
        this.questionType = questionType;
    }

    public QuestionType(String questionType, CategoryQuestionType category) {
        this.questionType = questionType;
        this.category = category;
    }


    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public CategoryQuestionType getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestionType category) {
        this.category = category;
    }


    public static class CategoryQuestionType {

        private String category;
        private SubCategory subCategory;

        public CategoryQuestionType(String category, SubCategory subCategory) {
            this.category = category;
            this.subCategory = subCategory;
        }

        public CategoryQuestionType(String category) {

            this.category = category;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public SubCategory getSubCategory() {
            return subCategory;
        }

        public void setSubCategory(SubCategory subCategory) {
            this.subCategory = subCategory;
        }


        public static class SubCategory {
            public SubCategory(String subCategory) {
                this.subCategory = subCategory;
            }

            private String subCategory;

            public String getSubCategory() {
                return subCategory;
            }

            public void setSubCategory(String subCategory) {
                this.subCategory = subCategory;
            }


        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        QuestionType questionType = (QuestionType) obj;
        return  questionType.getQuestionType().equals(this.getQuestionType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionType());
    }
}
