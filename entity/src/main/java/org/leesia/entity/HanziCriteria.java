package org.leesia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HanziCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HanziCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHanziIsNull() {
            addCriterion("HANZI is null");
            return (Criteria) this;
        }

        public Criteria andHanziIsNotNull() {
            addCriterion("HANZI is not null");
            return (Criteria) this;
        }

        public Criteria andHanziEqualTo(String value) {
            addCriterion("HANZI =", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziNotEqualTo(String value) {
            addCriterion("HANZI <>", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziGreaterThan(String value) {
            addCriterion("HANZI >", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziGreaterThanOrEqualTo(String value) {
            addCriterion("HANZI >=", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziLessThan(String value) {
            addCriterion("HANZI <", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziLessThanOrEqualTo(String value) {
            addCriterion("HANZI <=", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziLike(String value) {
            addCriterion("HANZI like", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziNotLike(String value) {
            addCriterion("HANZI not like", value, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziIn(List<String> values) {
            addCriterion("HANZI in", values, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziNotIn(List<String> values) {
            addCriterion("HANZI not in", values, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziBetween(String value1, String value2) {
            addCriterion("HANZI between", value1, value2, "hanzi");
            return (Criteria) this;
        }

        public Criteria andHanziNotBetween(String value1, String value2) {
            addCriterion("HANZI not between", value1, value2, "hanzi");
            return (Criteria) this;
        }

        public Criteria andIsNameIsNull() {
            addCriterion("IS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andIsNameIsNotNull() {
            addCriterion("IS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andIsNameEqualTo(Boolean value) {
            addCriterion("IS_NAME =", value, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameNotEqualTo(Boolean value) {
            addCriterion("IS_NAME <>", value, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameGreaterThan(Boolean value) {
            addCriterion("IS_NAME >", value, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_NAME >=", value, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameLessThan(Boolean value) {
            addCriterion("IS_NAME <", value, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_NAME <=", value, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameIn(List<Boolean> values) {
            addCriterion("IS_NAME in", values, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameNotIn(List<Boolean> values) {
            addCriterion("IS_NAME not in", values, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_NAME between", value1, value2, "isName");
            return (Criteria) this;
        }

        public Criteria andIsNameNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_NAME not between", value1, value2, "isName");
            return (Criteria) this;
        }

        public Criteria andIsSecondIsNull() {
            addCriterion("IS_SECOND is null");
            return (Criteria) this;
        }

        public Criteria andIsSecondIsNotNull() {
            addCriterion("IS_SECOND is not null");
            return (Criteria) this;
        }

        public Criteria andIsSecondEqualTo(Boolean value) {
            addCriterion("IS_SECOND =", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondNotEqualTo(Boolean value) {
            addCriterion("IS_SECOND <>", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondGreaterThan(Boolean value) {
            addCriterion("IS_SECOND >", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_SECOND >=", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondLessThan(Boolean value) {
            addCriterion("IS_SECOND <", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_SECOND <=", value, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondIn(List<Boolean> values) {
            addCriterion("IS_SECOND in", values, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondNotIn(List<Boolean> values) {
            addCriterion("IS_SECOND not in", values, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_SECOND between", value1, value2, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsSecondNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_SECOND not between", value1, value2, "isSecond");
            return (Criteria) this;
        }

        public Criteria andIsThirdIsNull() {
            addCriterion("IS_THIRD is null");
            return (Criteria) this;
        }

        public Criteria andIsThirdIsNotNull() {
            addCriterion("IS_THIRD is not null");
            return (Criteria) this;
        }

        public Criteria andIsThirdEqualTo(Boolean value) {
            addCriterion("IS_THIRD =", value, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdNotEqualTo(Boolean value) {
            addCriterion("IS_THIRD <>", value, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdGreaterThan(Boolean value) {
            addCriterion("IS_THIRD >", value, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_THIRD >=", value, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdLessThan(Boolean value) {
            addCriterion("IS_THIRD <", value, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_THIRD <=", value, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdIn(List<Boolean> values) {
            addCriterion("IS_THIRD in", values, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdNotIn(List<Boolean> values) {
            addCriterion("IS_THIRD not in", values, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_THIRD between", value1, value2, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsThirdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_THIRD not between", value1, value2, "isThird");
            return (Criteria) this;
        }

        public Criteria andIsMaleIsNull() {
            addCriterion("IS_MALE is null");
            return (Criteria) this;
        }

        public Criteria andIsMaleIsNotNull() {
            addCriterion("IS_MALE is not null");
            return (Criteria) this;
        }

        public Criteria andIsMaleEqualTo(Boolean value) {
            addCriterion("IS_MALE =", value, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleNotEqualTo(Boolean value) {
            addCriterion("IS_MALE <>", value, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleGreaterThan(Boolean value) {
            addCriterion("IS_MALE >", value, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_MALE >=", value, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleLessThan(Boolean value) {
            addCriterion("IS_MALE <", value, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_MALE <=", value, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleIn(List<Boolean> values) {
            addCriterion("IS_MALE in", values, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleNotIn(List<Boolean> values) {
            addCriterion("IS_MALE not in", values, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_MALE between", value1, value2, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsMaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_MALE not between", value1, value2, "isMale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleIsNull() {
            addCriterion("IS_FEMALE is null");
            return (Criteria) this;
        }

        public Criteria andIsFemaleIsNotNull() {
            addCriterion("IS_FEMALE is not null");
            return (Criteria) this;
        }

        public Criteria andIsFemaleEqualTo(Boolean value) {
            addCriterion("IS_FEMALE =", value, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleNotEqualTo(Boolean value) {
            addCriterion("IS_FEMALE <>", value, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleGreaterThan(Boolean value) {
            addCriterion("IS_FEMALE >", value, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_FEMALE >=", value, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleLessThan(Boolean value) {
            addCriterion("IS_FEMALE <", value, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_FEMALE <=", value, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleIn(List<Boolean> values) {
            addCriterion("IS_FEMALE in", values, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleNotIn(List<Boolean> values) {
            addCriterion("IS_FEMALE not in", values, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_FEMALE between", value1, value2, "isFemale");
            return (Criteria) this;
        }

        public Criteria andIsFemaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_FEMALE not between", value1, value2, "isFemale");
            return (Criteria) this;
        }

        public Criteria andMalePerfectIsNull() {
            addCriterion("MALE_PERFECT is null");
            return (Criteria) this;
        }

        public Criteria andMalePerfectIsNotNull() {
            addCriterion("MALE_PERFECT is not null");
            return (Criteria) this;
        }

        public Criteria andMalePerfectEqualTo(Boolean value) {
            addCriterion("MALE_PERFECT =", value, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectNotEqualTo(Boolean value) {
            addCriterion("MALE_PERFECT <>", value, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectGreaterThan(Boolean value) {
            addCriterion("MALE_PERFECT >", value, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectGreaterThanOrEqualTo(Boolean value) {
            addCriterion("MALE_PERFECT >=", value, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectLessThan(Boolean value) {
            addCriterion("MALE_PERFECT <", value, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectLessThanOrEqualTo(Boolean value) {
            addCriterion("MALE_PERFECT <=", value, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectIn(List<Boolean> values) {
            addCriterion("MALE_PERFECT in", values, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectNotIn(List<Boolean> values) {
            addCriterion("MALE_PERFECT not in", values, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectBetween(Boolean value1, Boolean value2) {
            addCriterion("MALE_PERFECT between", value1, value2, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andMalePerfectNotBetween(Boolean value1, Boolean value2) {
            addCriterion("MALE_PERFECT not between", value1, value2, "malePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectIsNull() {
            addCriterion("FEMALE_PERFECT is null");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectIsNotNull() {
            addCriterion("FEMALE_PERFECT is not null");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectEqualTo(Boolean value) {
            addCriterion("FEMALE_PERFECT =", value, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectNotEqualTo(Boolean value) {
            addCriterion("FEMALE_PERFECT <>", value, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectGreaterThan(Boolean value) {
            addCriterion("FEMALE_PERFECT >", value, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectGreaterThanOrEqualTo(Boolean value) {
            addCriterion("FEMALE_PERFECT >=", value, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectLessThan(Boolean value) {
            addCriterion("FEMALE_PERFECT <", value, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectLessThanOrEqualTo(Boolean value) {
            addCriterion("FEMALE_PERFECT <=", value, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectIn(List<Boolean> values) {
            addCriterion("FEMALE_PERFECT in", values, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectNotIn(List<Boolean> values) {
            addCriterion("FEMALE_PERFECT not in", values, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectBetween(Boolean value1, Boolean value2) {
            addCriterion("FEMALE_PERFECT between", value1, value2, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andFemalePerfectNotBetween(Boolean value1, Boolean value2) {
            addCriterion("FEMALE_PERFECT not between", value1, value2, "femalePerfect");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("CREATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("CREATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("CREATE_DATETIME =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("CREATE_DATETIME <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("CREATE_DATETIME >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATETIME >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("CREATE_DATETIME <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATETIME <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("CREATE_DATETIME in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("CREATE_DATETIME not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATETIME between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATETIME not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNull() {
            addCriterion("UPDATE_DATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIsNotNull() {
            addCriterion("UPDATE_DATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME =", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <>", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThan(Date value) {
            addCriterion("UPDATE_DATETIME >", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME >=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThan(Date value) {
            addCriterion("UPDATE_DATETIME <", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATETIME <=", value, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotIn(List<Date> values) {
            addCriterion("UPDATE_DATETIME not in", values, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATETIME not between", value1, value2, "updateDatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}