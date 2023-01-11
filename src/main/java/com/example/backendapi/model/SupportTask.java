package com.example.backendapi.model;

public class SupportTask {

        public String getStatus() {
                return status;}
            public void setStatus(String status) {
                this.status = status;}

            public String getPriority() {
                return priority;}

            public void setPriority(String priority) {
                this.priority = priority;}

            //EnumSet<Status> status = EnumSet.of(Status.DONE, Status.PENDING, Status.INPROGRESS);

            public enum Status {
                PENDING, INPROGRESS, DONE}

            private Long id;

            protected long customerId;

            private String priority;

            private String status ;

            public Long getId() {
                return id;}

            public void setId(Long id) {
                this.id = id;}

            public long getCustomerId() {
                return customerId;
            }
            public void setCustomerId(long customerId) {
                this.customerId = customerId;
            }

}
