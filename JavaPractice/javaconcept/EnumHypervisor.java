
/**
 * Created by jayapal_uradi on 3/2/17.
 */
  enum   Hypervisor {
    XENSERVER("xenserver"),
    KVM("kvm"),
    VMWARE("vmware"),
    ANY("any");

    private final String hypervisorType;

    Hypervisor(String htye) {
        this.hypervisorType = htye;
    }

    public static Hypervisor getHypervisorType(String htype) {

        if (htype.equals(XENSERVER.hypervisorType)) {
            return Hypervisor.XENSERVER;
        }

        if (htype.equals(KVM.hypervisorType)) {
            return Hypervisor.KVM;
        }

        if (htype.equals(VMWARE.hypervisorType)) {
            return Hypervisor.VMWARE;
        }

        return Hypervisor.ANY;
    }
}

public class EnumHypervisor {

    public static void main (String[] args) {

        String h="kvm";
        System.out.println(Hypervisor.getHypervisorType(h));
    }
}


