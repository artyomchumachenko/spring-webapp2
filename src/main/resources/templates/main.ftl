<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
    <div>
        <form method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="text" placeholder="Enter your message"/>
            <input type="text" name="tag" placeholder="Tag">
            <button type="submit">Add</button>
        </form>
    </div>
    <div>List messages</div>
    <form method="post" action="filter">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}"/>
        <input type="text" name="filter">
        <button type="submit">Search</button>
    </form>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        No messages
    </#list>
</@c.page>