get_domain_details = function (domainName, domainList ) {
    let mail_from_access = domainList[domainName];
    console.log("domain name = ", domainName);
    console.log("mail_from_access  = ", mail_from_access);
    if (mail_from_access) {
        console.log("returning ##### = ", mail_from_access);
        return mail_from_access;
    } else {
        let length = domainName.match(/\./g).length;
        console.log("length  = ", length);
        if (length && length > 1) {
            let extracted_domain = domainName.substring(domainName.indexOf(".") + 1);
            console.log("extracted_domain  = ", extracted_domain);
            return this.get_domain_details(extracted_domain, domainList);
        } else {
            return;
        }
    }
};

let domainList = { "123.com": "123.com", "netapp.com": "netapp.com"};

get_domain_details("xyz.mail.123.com", domainList);