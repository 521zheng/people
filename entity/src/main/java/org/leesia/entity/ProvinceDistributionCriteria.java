package org.leesia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProvinceDistributionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProvinceDistributionCriteria() {
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

        public Criteria andProvinceNameIsNull() {
            addCriterion("PROVINCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("PROVINCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("PROVINCE_NAME =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("PROVINCE_NAME <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("PROVINCE_NAME >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("PROVINCE_NAME <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("PROVINCE_NAME like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("PROVINCE_NAME not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("PROVINCE_NAME in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("PROVINCE_NAME not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andDistributionIsNull() {
            addCriterion("DISTRIBUTION is null");
            return (Criteria) this;
        }

        public Criteria andDistributionIsNotNull() {
            addCriterion("DISTRIBUTION is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionEqualTo(Double value) {
            addCriterion("DISTRIBUTION =", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotEqualTo(Double value) {
            addCriterion("DISTRIBUTION <>", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionGreaterThan(Double value) {
            addCriterion("DISTRIBUTION >", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionGreaterThanOrEqualTo(Double value) {
            addCriterion("DISTRIBUTION >=", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLessThan(Double value) {
            addCriterion("DISTRIBUTION <", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionLessThanOrEqualTo(Double value) {
            addCriterion("DISTRIBUTION <=", value, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionIn(List<Double> values) {
            addCriterion("DISTRIBUTION in", values, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotIn(List<Double> values) {
            addCriterion("DISTRIBUTION not in", values, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionBetween(Double value1, Double value2) {
            addCriterion("DISTRIBUTION between", value1, value2, "distribution");
            return (Criteria) this;
        }

        public Criteria andDistributionNotBetween(Double value1, Double value2) {
            addCriterion("DISTRIBUTION not between", value1, value2, "distribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionIsNull() {
            addCriterion("NATION_DISTRIBUTION is null");
            return (Criteria) this;
        }

        public Criteria andNationDistributionIsNotNull() {
            addCriterion("NATION_DISTRIBUTION is not null");
            return (Criteria) this;
        }

        public Criteria andNationDistributionEqualTo(String value) {
            addCriterion("NATION_DISTRIBUTION =", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionNotEqualTo(String value) {
            addCriterion("NATION_DISTRIBUTION <>", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionGreaterThan(String value) {
            addCriterion("NATION_DISTRIBUTION >", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionGreaterThanOrEqualTo(String value) {
            addCriterion("NATION_DISTRIBUTION >=", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionLessThan(String value) {
            addCriterion("NATION_DISTRIBUTION <", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionLessThanOrEqualTo(String value) {
            addCriterion("NATION_DISTRIBUTION <=", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionLike(String value) {
            addCriterion("NATION_DISTRIBUTION like", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionNotLike(String value) {
            addCriterion("NATION_DISTRIBUTION not like", value, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionIn(List<String> values) {
            addCriterion("NATION_DISTRIBUTION in", values, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionNotIn(List<String> values) {
            addCriterion("NATION_DISTRIBUTION not in", values, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionBetween(String value1, String value2) {
            addCriterion("NATION_DISTRIBUTION between", value1, value2, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andNationDistributionNotBetween(String value1, String value2) {
            addCriterion("NATION_DISTRIBUTION not between", value1, value2, "nationDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionIsNull() {
            addCriterion("SEX_DISTRIBUTION is null");
            return (Criteria) this;
        }

        public Criteria andSexDistributionIsNotNull() {
            addCriterion("SEX_DISTRIBUTION is not null");
            return (Criteria) this;
        }

        public Criteria andSexDistributionEqualTo(String value) {
            addCriterion("SEX_DISTRIBUTION =", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionNotEqualTo(String value) {
            addCriterion("SEX_DISTRIBUTION <>", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionGreaterThan(String value) {
            addCriterion("SEX_DISTRIBUTION >", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionGreaterThanOrEqualTo(String value) {
            addCriterion("SEX_DISTRIBUTION >=", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionLessThan(String value) {
            addCriterion("SEX_DISTRIBUTION <", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionLessThanOrEqualTo(String value) {
            addCriterion("SEX_DISTRIBUTION <=", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionLike(String value) {
            addCriterion("SEX_DISTRIBUTION like", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionNotLike(String value) {
            addCriterion("SEX_DISTRIBUTION not like", value, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionIn(List<String> values) {
            addCriterion("SEX_DISTRIBUTION in", values, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionNotIn(List<String> values) {
            addCriterion("SEX_DISTRIBUTION not in", values, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionBetween(String value1, String value2) {
            addCriterion("SEX_DISTRIBUTION between", value1, value2, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andSexDistributionNotBetween(String value1, String value2) {
            addCriterion("SEX_DISTRIBUTION not between", value1, value2, "sexDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionIsNull() {
            addCriterion("LAST_NAME_DISTRIBUTION is null");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionIsNotNull() {
            addCriterion("LAST_NAME_DISTRIBUTION is not null");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionEqualTo(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION =", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionNotEqualTo(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION <>", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionGreaterThan(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION >", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION >=", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionLessThan(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION <", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionLessThanOrEqualTo(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION <=", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionLike(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION like", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionNotLike(String value) {
            addCriterion("LAST_NAME_DISTRIBUTION not like", value, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionIn(List<String> values) {
            addCriterion("LAST_NAME_DISTRIBUTION in", values, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionNotIn(List<String> values) {
            addCriterion("LAST_NAME_DISTRIBUTION not in", values, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionBetween(String value1, String value2) {
            addCriterion("LAST_NAME_DISTRIBUTION between", value1, value2, "lastNameDistribution");
            return (Criteria) this;
        }

        public Criteria andLastNameDistributionNotBetween(String value1, String value2) {
            addCriterion("LAST_NAME_DISTRIBUTION not between", value1, value2, "lastNameDistribution");
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